class Solution:
    def maximumSwap(self, num: int) -> int:
        s = list(str(num))
        rs = sorted(s,reverse = True)
        n=len(s)
        for i in range(n):
            a,b=s[i],rs[i]
            if a!=b:
                # 找到不一样的了，就换它
                for j in range(n-1,-1,-1):
                    if s[j]==b:
                        s[i],s[j]=b,a
                        return int(''.join(s))
        return num
