class Solution:
    def baseNeg2(self, n: int) -> str:
        # 短除取余法 ，每次 n //= -2 将相当于右移一次。 剩下的余数就是答案了。本题余有-1，但不能表示为-1，余了-1，就要将剩余的被除数+1
        if n==0:
            return '0'
        ans=[]
        while n:
            remain = n%(-2)
            n//=-2
            if remain<0:
                n+=1
            ans.append('1' if remain else '0')
        a=''
        for i in range(len(ans)-1,-1,-1):
            a+=ans[i]
        return a

        # 递归
        # if n == 0: return '0'
        # if n == 1: return '1'
        # if n & 1: return self.baseNeg2((n - 1) // -2) + '1'
        # return self.baseNeg2(n // -2) + '0'