class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        @cache
        def dfs(i,c):
            '''
            前i种硬币能凑成c额度的组合数
            '''
            if i<0: # 没有硬币，额度为0也是种方案
                return 1 if c==0 else 0
            if c<coins[i]: # 这个硬币比面额还大，只能用前面的小额硬币来凑
                return dfs(i-1,c)
            # 用这个硬币和不用这个硬币的方案和
            return dfs(i-1,c)+dfs(i,c-coins[i])
        return dfs(len(coins)-1,amount)