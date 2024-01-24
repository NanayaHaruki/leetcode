class Solution:
    def maximumSumOfHeights(self, maxHeights: List[int]) -> int:
        n=len(maxHeights)
        res=0
        st=[-1]
        pre=[0]*n
        s=0
        for i,x in enumerate(maxHeights):
            while len(st)>1 and x<=maxHeights[st[-1]]:
                p=st.pop()
                # p前面的到p这一段要去掉，换成x
                s-=maxHeights[p]*(p-st[-1])
            s+=x*(i-st[-1])
            pre[i]=s
            st.append(i)
        s=0
        st=[n]
        for i in range(n-1,-1,-1):
            x=maxHeights[i]
            while len(st)>1 and x<=maxHeights[st[-1]]:
                p=st.pop()
                s-=maxHeights[p]*(st[-1]-p)
            s+=x*(st[-1]-i)
            st.append(i)
            res=max(res,s + (pre[i-1] if i else 0))
        return res