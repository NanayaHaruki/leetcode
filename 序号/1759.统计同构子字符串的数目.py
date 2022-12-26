class Solution:
    def countHomogenous(self, s: str) -> int:
        """同构子串数量"""
        # 数连续字符长度，存起来
        # 长度为i的长串，它的子串个数为 1+2+。。+i  即 i*(1+i)/2
        ans, cnt, char,mod = 0, 0, "0",int(1e9+7)
        s += "0"
        for c in s:
            if c == char:
                cnt += 1
            else:
                ans += (cnt + 1) * cnt // 2
                ans%=mod
                cnt = 1
                char = c
        return ans