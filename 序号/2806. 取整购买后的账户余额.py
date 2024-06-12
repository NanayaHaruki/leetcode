class Solution:
    def accountBalanceAfterPurchase(self, purchaseAmount: int) -> int:
        m = purchaseAmount%10
        if m==5:
            purchaseAmount+=5
        elif m<5:
            purchaseAmount-=m
        else:
            purchaseAmount+=10-m
        return 100-purchaseAmount