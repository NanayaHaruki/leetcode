class Solution:
    def bestTeamScore(self, scores: List[int], ages: List[int]) -> int:
        # 对年龄排序，年龄相同对分数排序
        # 定义dp[i] 为i作为队员中年龄最大且分数最高的，全队分数和
        # 因为按照年龄排序 j<i 所有人年龄都更小，按照题意，年龄小的分数不能比i大，在[0,j)中找分数<=i的f[j]最大值，遍历完后加上i的分数构成新的dp[i]
        member = sorted(zip(ages, scores))
        n=len(ages)
        dp=[0]*n
        for i in range(n):
            for j in range(i):
                if member[j][1]<=member[i][1]:
                    dp[i]= max(dp[i],dp[j])
            dp[i]+=member[i][1]
        return max(dp)