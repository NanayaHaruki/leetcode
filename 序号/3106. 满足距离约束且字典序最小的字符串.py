class Solution:
    def getSmallestString(self, s: str, k: int) -> str:
        i,n=0,len(s)
        cs = list(s)
        while i<n and k:
            c = cs[i]
            diff = min(ord('z')-ord(c)+1,ord(c)-ord('a'))
            if diff<=k:
                cs[i]='a'
                k-=diff
            else:
                cs[i]=chr(ord(c)-k)
                k=0
            if k==0:
                break
            i+=1
        return ''.join(cs)