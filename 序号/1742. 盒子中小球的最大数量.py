class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        # 找数字和一样的数有多少个    
        high = str(highLimit)
        n=len(high)
        low=str(lowLimit).zfill(n)
        @cache
        def dfs(i,low_limit,high_limit,left):
            if left<0:
                return 0
            if i==n:
                return left==0
            lo = int(low[i]) if low_limit else 0
            hi = int(high[i]) if high_limit else 9
            res=0
            for j in range(lo,hi+1):
                res+= dfs(i+1,low_limit and lo==j,high_limit and hi==j,left-j)
            return res
            
        ans=0
        for i in range(1,int(high[0])+(n-1)*9+1): # 遍历所有可能的数位和，统计个数
            ans=max(ans,dfs(0,True,True,i))
        return ans