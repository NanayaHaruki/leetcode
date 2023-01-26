class Solution:
    def getSmallestString(self, n: int, k: int) -> str:
        k-=n
        ans='z'*(k//25) 
        if k%25: 
            ans=chr(ord('a')+k%25)+ans
        ans='a'*(n-len(ans))+ans
        return ans