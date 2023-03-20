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