class Solution:
    def minimumCoins(self, prices: List[int]) -> int:
        n = len(prices)
        @cache  # 缓存装饰器，避免重复计算 dfs 的结果（记忆化）
        def dfs(i: int) -> int:
            if i * 2 >= n:
                return prices[i - 1]  # i 从 1 开始
            return min(dfs(j) for j in range(i + 1, i * 2 + 2)) + prices[i - 1]
        return dfs(1)
