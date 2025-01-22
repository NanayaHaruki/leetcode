class Solution:
    def maxCoins(self, piles: List[int]) -> int:
        piles.sort()
        n=len(piles)//3
        a=0
        for i in range(n,len(piles),2):
            a+=piles[i]
        return a