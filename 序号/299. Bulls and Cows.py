class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        a,b=0,0
        ds = [set() for _ in range(10)]
        dg= [set() for _ in range(10)]
        for i,x in enumerate(secret):
            ds[int(x)].add(i)
        for i,x in enumerate(guess):
            dg[int(x)].add(i)
        for i in range(10): # 猜i这个数字的索引st
            sg = dg[i]
            ss = ds[i] # ss为实际这个数字的索引
            curB = min(len(sg),len(ss)) # 长度较小的为猜对的数量。 实际有3个，猜有4个，对3个。实际3个，猜有2个，对2个。
            curA = len(sg & ss) # 交集数量表示数字和位置都猜对了
            a+=curA
            b+=(curB-curA)
        return f'{a}A{b}B'