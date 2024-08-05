class Solution:
    def findIntegers(self, n: int) -> int:
        # [0,n]统计多少个数，二进制里没有连续的1
        s=str(bin(n))[2:]
        @cache
        def f(i,preIs1,isLimit):
            if i==len(s):
                return 1
            ans=0
            end= int(s[i]) if isLimit else 1
            ans+=f(i+1,False,isLimit and end==0)
            if not preIs1 and end==1:
                ans+=f(i+1,True,isLimit)
            return ans
        return f(0,False,True)
# 24 08 05
class Solution:
    def findIntegers(self, n: int) -> int:
        @cache
        def dfs(i: int, pre1: bool, is_limit: bool) -> int:
            if i < 0:
                return 1
            up = n >> i & 1 if is_limit else 1
            res = dfs(i - 1, False, is_limit and up == 0)  # 填 0
            if not pre1 and up == 1:  # 可以填 1
                res += dfs(i - 1, True, is_limit)  # 填 1
            return res
        return dfs(n.bit_length() - 1, False, True)  # 从高位到低位
