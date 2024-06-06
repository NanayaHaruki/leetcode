class Solution:
    def minimumSteps(self, s: str) -> int:
        cs = list(s)
        n = len(s)
        ans=0
        i=n-1
        end = n-1
        while i>=0:
            j=i
            while j>=0 and cs[j]=='0':j-=1
            if j<0:break
            ans+=end-j
            end-=1
            i=j-1
        return ans