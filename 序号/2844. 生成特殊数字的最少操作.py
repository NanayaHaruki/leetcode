class Solution:
    def minimumOperations(self, num: str) -> int:
        cs = list(num)
        n = len(cs)
        # 结尾是25 75 50 00
        def f(lastChar):
            i=n-1
            while i>=0:
                if cs[i]==lastChar:
                    break
                i-=1
            if i==-1:return n
            next_char = ('2','7') if lastChar=='5' else ('5','0')
            j=i-1
            while j>=0 and num[j] not in next_char:
                j-=1
            if j==-1:return n if lastChar=='5' else n-1 # lastchar 是0，就不用全删了
            return n-1-i+i-j-1
        return min(f('5'),f('0'))