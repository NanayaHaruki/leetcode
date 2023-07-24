class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        d=[0]*128
        for j in jewels:
            d[ord(j)-ord('A')]=1
        ans=0
        for s in stones:
            if d[ord(s)-ord('A')]:
                ans+=1
        return ans