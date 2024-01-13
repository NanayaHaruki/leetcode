class Solution:
    def repeatLimitedString(self, s: str, repeatLimit: int) -> str:
        cnts=[0]*128
        for c in s:
            cnts[ord(c)]+=1
        ans=''
        r=127
        l=126
        while True:
            while r>96 and cnts[r]==0:r-=1
            if r==96:break
            if cnts[r]<=repeatLimit:
                ans+=chr(r)*cnts[r]
                cnts[r]=0
            else:
                ans+=chr(r)*repeatLimit
                l=min(l,r-1)
                while l>96 and cnts[l]==0:l-=1
                if l==96:break
                ans+=chr(l)
                cnts[l]-=1
                cnts[r]-=repeatLimit
        return ans