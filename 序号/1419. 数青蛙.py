class Solution:
    def minNumberOfFrogs(self, croakOfFrogs: str) -> int:
        # croak 碰到c就往队列加个新的字符，如果是别的，就找能匹配上的
        d = {"c": 0, "r": 0, "o": 0, "a": 0, "k": 0}
        ans = 0
        for c in croakOfFrogs:
            if c == "c":
                if ans==sum(d.values()): # 正在唱的蛙 = 最大蛙，此时又来个声音; 唱完了，sum变小，ans不变，此时 ans>sum 来声音不用增加蛙;
                    ans += 1
                d[c] += 1

            elif c == "r":
                if d["c"]:
                    d["c"] -= 1
                    d["r"] += 1
                else:
                    return -1
            elif c == "o":
                if d["r"]:
                    d["r"] -= 1
                    d["o"] += 1
                else:
                    return -1
            elif c == "a":
                if d["o"]:
                    d["o"] -= 1
                    d["a"] += 1
                else:
                    return -1
            else:
                if d["a"]:
                    d["a"] -= 1
                else:
                    return -1
        for chr, cnt in d.items():
            if cnt:
                return -1
        return ans