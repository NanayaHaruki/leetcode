class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        a,b=-prices[0],0
        for i in range(1,len(prices)):
            tmp=a
            a=max(b-prices[i],a)#今天持有股票，是昨天持有今天继续持有 或 昨天持有股票获得的利润-今天买入损失的
            b=max(b,tmp+prices[i])#今天不持有，是昨天不持有 或 昨天持有今天卖了
        return max(a,b)