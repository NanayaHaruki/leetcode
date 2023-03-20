class Solution:
    def countDigitOne(self, n: int) -> int:
        # [0,n] 中1出现的个数
        s = str(n)
        @cache
        def f(i,cnt,isLimit,isNum):
            if i==len(s):
                return cnt
            ans=0
            if not isNum:
                ans+=f(i+1,cnt,False,False)
            for d in range(1-int(isNum),1+(int(s[i]) if isLimit else 9)):
                ans+=f(i+1,cnt+(d==1),isLimit and d==int(s[i]),True)
            return ans
        return f(0,0,True,False)