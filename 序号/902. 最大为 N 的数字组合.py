class Solution:
    def atMostNGivenDigitSet(self, digits: List[str], n: int) -> int:
        high = str(n)
        n=len(high)
        @cache
        def dfs(i,high_limit,leadingZero):
            if i==n:
                return not leadingZero
            hi = high[i] if high_limit else '9'
            res=0
            if leadingZero:
                res+=dfs(i+1,False,True)
            for j in digits:
                if j>hi:break
                res+=dfs(i+1,high_limit and j==hi,False)
            # print(i,res)
            return res
        return dfs(0,True,True)