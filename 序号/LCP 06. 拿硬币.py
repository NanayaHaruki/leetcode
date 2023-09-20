class Solution:
    def minCount(self, coins: List[int]) -> int:
        ans=0
        for x in coins:
            ans+=x//2
            if x%2:
                ans+=1
        return ans