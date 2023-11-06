class Solution:
    def maxProduct(self, words: List[str]) -> int:
        n=len(words)
        f=[0]*n
        for i,x in enumerate(words):
            for c in x:
                f[i] |= (1<<(ord(c)-ord('a')))        
        ans=0
        for i in range(n-1):
            for j in range(i+1,n):
                if f[i] ^ f[j]==f[i]+f[j]:
                    ans=max(ans,len(words[i])*len(words[j]))
        return ans
