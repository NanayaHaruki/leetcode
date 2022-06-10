'''
cv
'''
class Solution:
    MOD = int(1e9 + 7)

    def countPalindromicSubsequences(self, s: str) -> int:
        n = len(s)
        f = [[0 for _ in range(n)] for _ in range(n)]
        L = [-1] * 4
        R = [0] * 4
        for i in range(n - 1, -1, -1):
            L[ord(s[i]) - 97] = i
            for j in range(4):
                R[j] = -1
            for j in range(i, n):
                R[ord(s[j]) - 97] = j
                for k in range(4):
                    if (L[k] == -1 or R[k] == -1): continue
                    l = L[k]
                    r = R[k]
                    if (l == r): f[i][j] = (f[i][j] + 1) % Solution.MOD
                    elif (l == r - 1): f[i][j] = (f[i][j] + 2) % Solution.MOD
                    else:
                        f[i][j] = (f[i][j] + f[l + 1][r - 1] + 2) % Solution.MOD

        return f[0][n-1]
