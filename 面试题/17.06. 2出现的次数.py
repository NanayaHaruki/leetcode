class Solution:
    def numberOf2sInRange(self, n: int) -> int:
        s = str(n)
        @cache
        def f(i,cnt,isLimit,isNum):
            if i==len(s):
                return cnt
            ans=0
            if not isNum:
                ans+=f(i+1,cnt,False,False)
            start,end=0 if isNum else 1,int(s[i]) if isLimit else 9
            for d in range(start,end+1):
                ans+=f(i+1,cnt+(d==2),isLimit and d==end,True)
            return ans
        return f(0,0,True,False)