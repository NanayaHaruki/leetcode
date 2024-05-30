class Solution:
    def maximumLength(self, s: str) -> int:
        n=len(s)
        m={}
        for i in range(n-2,0,-1): #i为长度
            m.clear()
            for j in range(0,n-i+1):
                cs = set(s[j:j+i])
                if len(cs)!=1:continue
                c=s[j]
                if c not in m:
                    m[c]=1
                else:
                    if m[c]==2:
                        return i
                    else:
                        m[c]+=1
        return -1