class Solution:
    def findTheLongestBalancedSubstring(self, s: str) -> int:
        c0, c1, ans = 0, 0, 0
        pre = "2"
        for x in s:
            if x == "0":
                if pre != "0":
                    c0 = 1
                else:
                    c0 += 1
            else:
                if pre != "1":
                    c1 = 1
                else:
                    c1 += 1
                ans = max(ans, min(c0, c1) * 2)
            pre = x
        return ans