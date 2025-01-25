class Solution:
    def minimumMoney(self, transactions: List[List[int]]) -> int:
        loss = mxCostBack = 0
        for cost,costBack in transactions:
            if cost>costBack:
                loss+=cost-costBack
                mxCostBack=max(mxCostBack,costBack)
            else:
                mxCostBack=max(mxCostBack,cost)
        return loss+mxCostBack