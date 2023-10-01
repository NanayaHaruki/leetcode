class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy=-prices[0]
        ans=0
        for  i in range(1,len(prices)):
            x=prices[i]
            ans=max(x+buy,ans)
            buy=max(buy,-x)
        return ans
