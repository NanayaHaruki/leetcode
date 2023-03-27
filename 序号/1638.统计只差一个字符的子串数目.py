class Solution:
    def countSubstrings(self, s: str, t: str) -> int:
        """
        在s和t找到不同的点后，两个指针都往两边找，直到再次遇见不同的字符，两边长度+1的积就是可能的子串数量

        """
        # 用dp记录每个点的最长相同前缀和后缀
        m, n = len(s), len(t)
        dpl = [[0] * n for _ in range(m)]
        dpr = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if s[i] == t[j]:
                    if i > 0 and j > 0:
                        dpl[i][j] = dpl[i - 1][j - 1] + 1
                    else:
                        dpl[i][j] = 1
                else:
                    dpl[i][j] = 0
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if s[i] == t[j]:
                    if i < m - 1 and j < n - 1:
                        dpr[i][j] = dpr[i + 1][j + 1] + 1
                    else:
                        dpr[i][j] = 1
                else:
                    dpr[i][j] = 0
        ans = 0
        for i in range(m):
            for j in range(n):
                if s[i] != t[j]:
                    l = dpl[i - 1][j - 1] + 1 if i > 0 and j > 0 else 1
                    r = dpr[i + 1][j + 1] + 1 if i < m - 1 and j < n - 1 else 1
                    ans += l * r
        return ans
                    
        
        

    # 暴力
    # def countSubstrings(self, s: str, t: str) -> int:
    #     '''
    #     遍历s的不同长度，用这个长度作为滑动窗口在t上滑动，查找只有一个字符不等的数量
    #     '''
    #     ls,lt = len(s),len(t)
    #     ans=0
    #     for l in range(1,min(ls,lt)+1):
    #         for i in range(l,ls+1):
    #             curS = s[i-l:i]
    #             for j in range(l,lt+1):
    #                 curT = t[j-l:j]
    #                 diffCnt = 0
    #                 for k in range(l):
    #                     if curS[k]!=curT[k]:
    #                         diffCnt+=1
    #                         if diffCnt>1:
    #                             break
    #                 if diffCnt==1:
    #                     ans+=1
    #     return ans