class Solution:
    def maxRepOpt1(self, text: str) -> int:
        cnter=Counter(text)
        n=len(text)
        ans=i=j=0
        while i<n:
            j=i+1
            x=text[i]
            while j<n and text[j]==x:
                j+=1
            ans=max(ans,j-i) # text[j]是与x不一样的
            if j-i<cnter[x]:
                ans=max(ans,j-i+1) # 这段之外还有，那么可以在j的位置换一个过来 
           
            k=j+1 # 换过之后，找j后面能不能连上
            while k<n and text[k]==x:
                k+=1
            ans=max(ans,min(k-i,cnter[x])) # k中可能出现有一个x被上一步替换过了，k-i要判断不能超过总量
            i=j # text[j]不是x，判断其他字符的可能性
        return ans