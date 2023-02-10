class Solution:
    def dieSimulator(self, n: int, rollMax: List[int]) -> int:
        # n 次不同的序列
        mod = int(1e9+7)
        # 定义dp[i][j] 以j结尾的长度为i的序列数量
        dp=[[0]*6 for _ in range(n+1)]
        for i in range(6):
            dp[1][i]=1
        # dp[i][j]= sum(dp[0-5][j-1]) 同时考虑rollMax限制，所以长度要先遍历短的，将长度放在外面
        cnt=[1]*6
        for i in range(2,n+1):
            # 检查相同数目有没有超过限制
            for j in range(6):
                for k in range(6):
                    if j==k:
                        if cnt[j]==rollMax[j]:
                            cnt[j]=1 # 上一个是其他数字，本次是j自己
                        else:
                            cnt[j]+=1
                            dp[i][j]+=dp[i-1][k]
                    else:
                        dp[i][j]+=dp[i-1][k]
        return sum([dp[n][x] for x in range(6)]) % mod