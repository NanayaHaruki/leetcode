class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        have,notHave=-inf,0
        for x in prices:
            have=max(have,notHave-x-fee)
            notHave=max(notHave,have+x)
        return notHave