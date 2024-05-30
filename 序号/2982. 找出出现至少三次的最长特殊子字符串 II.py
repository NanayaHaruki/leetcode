class Solution:
    def maximumLength(self, s: str) -> int:
        n = len(s)
        l,r=0,n+1
        d = Counter()
        while l+1<r:
            m = (l+r)//2
            d.clear()
            i=0
            while i<n:
                j = i+1
                while j<n and s[i]==s[j]:j+=1
                # 'aaaaab'  i=0 j=5 能组成 aa 的有4个 = 5-0-2+1 = j-i-m+1 
                d[s[i]]+=max(0,j-i-m+1)
                i=j
            if max(d.values())>=3:
                l=m
            else :
                r=m      
        return -1 if l==0 else l