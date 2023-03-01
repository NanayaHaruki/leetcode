class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int: 
        '''questions[i] [points,skips] 解决当前问题，获得分数point，但后面skips个问题都不能回答'''
        n = len(questions)
        dp = [0]*(n+1) # dp[i] [i,n-1]的最大值
        for i in range(n-1,-1,-1):
            j = questions[i][1]+1+i
            # i不拿，就跟i+1相同，i拿了，就是当前值加上j的值
            dp[i]=max(dp[i+1],questions[i][0]+(dp[j] if j<n else 0)) 
        return dp[0]