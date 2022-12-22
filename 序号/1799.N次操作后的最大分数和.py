class Solution:
    def maxScore(self, nums: List[int]) -> int:
        """
        有2n个数，每次取出2个数，第i次取出两个数a，b，得分i*gcd(a,b)，求最大的分
        """
        # n[1,7],打表求出所有组合的最大公约数，同时建立dp的base case，操作第一次得分
        # 用二进制记录操作过哪些位置的数字 dp[i]=dp[i-(1<<a)-(1<<b)+gcd*i]
        n = len(nums)
        gcds = [[0] * n for i in range(n)] # 打表
        dp = [0]*(1<<n)
        ans=0
        for i in range(n):
            for j in range(i+1,n):
                gcds[i][j]=math.gcd(nums[i],nums[j])
        for x in range(1<<n):
            bitCnt = x.bit_count()
            if(bitCnt&1) :continue
            for i in range(n):
                if not (x & (1<<i)):continue
                for j in range(i+1,n):
                    if not (x & (1<<j)): continue
                    dp[x]=max(dp[x],dp[x-(1<<i)-(1<<j)]+ gcds[i][j]*bitCnt//2)
        return dp[-1]