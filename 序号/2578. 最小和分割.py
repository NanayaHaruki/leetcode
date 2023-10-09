class Solution:
    def splitNum(self, num: int) -> int:
        sl = sorted(str(num))
        a = b = 0
        for i, x in enumerate(sl):
            x = int(x)
            if i & 1:
                a = a * 10 + x
            else:
                b = b * 10 + x
        return a + b