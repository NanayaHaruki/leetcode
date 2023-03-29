class Solution:
    def countVowelStrings(self, n: int) -> int:
        # dp = [[0]*5 for _ in range(n+1)] # dp[i][j] 选了i个字母，最后一个是j的方案数 j[0,4] 对应五个元音字母
        # for i in range(5):
        #     dp[1][i]=1
        # for i in range(2,n+1):
        #     for j in range(5):
        #         for k in range(j+1):
        #             dp[i][j]+=dp[i-1][k]
        # return sum(dp[-1])

        # dp[i] 只与 dp[i-1] 有关，可以去除一个维度
        dp=[1]*5
        for i in range(2,n+1):
            s = 0
            for j in range(5):
                s+=dp[j]
                dp[j]=s
        return sum(dp)