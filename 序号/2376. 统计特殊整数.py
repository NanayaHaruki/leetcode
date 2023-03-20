class Solution:
    def countSpecialNumbers(self, n: int) -> int:
        s = str(n)
        @cache
        def f(i, vis, isLimit):
            if i == len(s):
                return 1 if vis else 0
            ans = 0
            if not vis:
                ans += f(i + 1, vis, False)
            for d in range(0 if vis else 1, 1 + (int(s[i]) if isLimit else 9)):
                if vis >> d & 1 == 0:  # 如果没遇到过
                    ans += f(i + 1, vis|(1<<d), isLimit and d == int(s[i]))
            return ans

        return f(0, 0, True)