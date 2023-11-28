class Solution:
    def punishmentNumber(self, n: int) -> int:
        def dfs(x,i):
            # 判断i*i能否分隔成和为i的几个数字
            if x==i:return True
            d=10
            while x>=d and x%d<=i: # x>=d 是可以对d取模，将x分割。 x%d是分割后的右半部分，要求分割后的和=i，则右半部分必定不能大于i
                if(dfs(x//d,i-x%d)):return True
                d*=10
            return False

        ans,i=0,1
        while i<=n:
            m=i%9
            if m>1:
                i+=7
                continue
            ans+=i*i if dfs(i*i,i) else 0
            i+=1
        return ans  