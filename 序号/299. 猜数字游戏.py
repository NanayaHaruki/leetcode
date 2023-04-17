class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        # 分别统计奶牛个数和公牛个数，公牛必定奶牛，所以奶牛个数返回时要减去公牛个数
        c=Counter(secret)
        bull,cow=0,0
        for i,x in enumerate(guess):
            if secret[i]==x:
                bull+=1
            if c[x]>0:
                cow+=1
                c[x]-=1
        return f'{bull}A{cow-bull}B'