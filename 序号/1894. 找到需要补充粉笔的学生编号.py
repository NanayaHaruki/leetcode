class Solution:
    def chalkReplacer(self, chalk: List[int], k: int) -> int:
        n=len(chalk)
        pre_sum = [0]*(n+1)
        for i in range(1,n+1):
            pre_sum[i]=pre_sum[i-1]+chalk[i-1]
        k%=pre_sum[-1]
        return bisect.bisect_right(pre_sum,k)-1
