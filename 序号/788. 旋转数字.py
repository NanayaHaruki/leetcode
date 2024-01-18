class Solution:
    def rotatedDigits(self, n: int) -> int:
        # 25 69 必须有
        # 0 1 8 可以有，如果只有0，旋转后是自己，不符要求
        low=str(1)
        high=str(n)
        n=len(high)
        low=low.zfill(n)

        nums={0,1,8,2,5,6,9}
        n2569={2,5,6,9}
        @cache
        def dfs(i,high_limit,has2569):
            if i==n:
                return has2569
            hi = int(high[i]) if high_limit else 9
            res=0
            for j in nums:
                if j>hi:continue
                res+=dfs(i+1,high_limit and j==hi,has2569 or j in n2569)
            return res
        return dfs(0,True,False)
            