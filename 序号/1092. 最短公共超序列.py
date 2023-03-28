class Solution:
    def shortestCommonSupersequence(self, s1: str, s2: str) -> str:
        # 先找出最长公共子序列 lcs，再把剩余字符插进去
        m, n = len(s1), len(s2)
        dp = [[''] * n for _ in range(m)]
        for i, x in enumerate(s1):
            for j, y in enumerate(s2):
                if x == y:
                    if i == 0 or j == 0:
                        dp[i][j] = x
                    else:
                        dp[i][j] = dp[i - 1][j - 1] + x
                else:
                    if i>0 :
                        dp[i][j]=dp[i-1][j]
                    if j>0 and len(dp[i][j-1])>len(dp[i][j]):
                        dp[i][j]=dp[i][j-1]
        lcs = dp[-1][-1]
        a, b, c,preA,preB = 0, 0,0,-1,-1
        ans=''
        while c<len(lcs): # 在c越界前，ab不可能越界，因为lcs是公共最长子序列
            while a< m and s1[a] != lcs[c]:
                a += 1
            while b<n and s2[b]!=lcs[c]:
                b+=1
            ans=ans+s1[preA+1:a]+s2[preB+1:b]+lcs[c]
            preA=a;preB=b;a+=1;b+=1;c+=1
        ans=ans+s1[a:]+s2[b:]
        return ans