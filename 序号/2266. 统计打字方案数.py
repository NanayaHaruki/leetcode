mod = 1_000_000_007 
class Solution:
    def countTexts(self, pressedKeys: str) -> int:
        @cache
        def calc(chr, cnt):
            if cnt == 1:
                return 1
            if cnt == 2:
                return 2
            if cnt == 3:
                return 4
            if chr == "7" or chr == "9":
                if cnt == 4:
                    return 8
                return (
                    sum(calc(chr, cnt - i) % mod for i in range(1, 5))
                    % mod
                )
            return (
                sum(calc(chr, cnt - i) % mod for i in range(1, 4)) % mod
            )
        
        c = "0"
        cnt = 0
        ans = 1
        for x in pressedKeys:
            if x == c:
                cnt += 1
            else:
                if c!='0':
                    ans = ans * calc(c, cnt) % mod
                c = x
                cnt = 1
        return ans * calc(c,cnt) % mod