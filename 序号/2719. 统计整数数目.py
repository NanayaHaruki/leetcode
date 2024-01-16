class Solution:
    def count(self, low: str, high: str, min_sum: int, max_sum: int) -> int:
        # 在 num1 和 num2 中间找 数字每位之和 在[min_sum,max_sum]之间
        # 数位dp
        n=len(high)
        low = '0'*(n-len(low))+low # 长度对齐

        @cache
        def dfs(i:int,lower_limit:bool,high_limit:bool,pre_sum:int):
            if i==n:
                return 1 if min_sum <= pre_sum <=max_sum else 0
            if pre_sum>max_sum:
                return 0
            # 计算第 i 位能够取的值
            lo = int(low[i]) if lower_limit else 0
            hi = int(high[i]) if high_limit else 9
            res=0
            for j in range(lo,hi+1):
                res+=dfs(i+1,lower_limit and j==lo,high_limit and j==hi,pre_sum+j)
            return res
        return dfs(0,True,True,0) % 1_000_000_007