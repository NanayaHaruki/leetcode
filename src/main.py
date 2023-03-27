from typing import List
from collections import Counter, defaultdict, deque
import math
import itertools
from functools import cache


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


i = Solution().countSubstrings("aba", "baba")
print(i)
