class Solution:
    def addMinimum(self, word: str) -> int:
        # 比前一个大1，不用改，对结果贡献0
        # 大2，贡献1   a (b) c
        # 相同，贡献2  b (ca) b
        # 少1，贡献1    b (c) a   c (a) b  
        # 少2 ，贡献0
        pre='c'
        ans=0
        for x in word:
            d = ord(x)-ord(pre)
            if d==2 or d==-1:
                ans+=1
            elif d==0:
                ans+=2
            pre=x
        if pre=='a':ans+=2
        elif pre=='b':ans+=1
        return ans