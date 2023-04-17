class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        c=Counter()
        l=r=mx=0
        while r<len(s):
            c[s[r]]+=1
            mx=max(mx,c[s[r]])
            r+=1
            if r-l-mx>k:
                c[s[l]]-=1
                l+=1
        return r-l