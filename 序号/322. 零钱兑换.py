class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        @cache
        def dfs(amount):
            if amount<0:return -1
            if amount==0:return 0
            # mn = min(dfs(amount-c) for c in coins)
            mn=-1
            for c in coins:
                p = dfs(amount-c)
                if p<0:continue
                if mn==-1:mn=p
                elif p<mn:mn=p
            # print(amount,mn)
            return -1 if mn==-1 else mn+1
        return dfs(amount)