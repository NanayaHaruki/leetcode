class Solution:
    def maxTaxiEarnings(self, n: int, rides: List[List[int]]) -> int:
        # 定义dfs返回[1,i]获得的利益，如果没人在i下车，则 dfs(i)=dfs(i-1)
        # 有人下车，就遍历所有在i下车的人 取最大值

        # 先记录终点下车的人
        g=defaultdict(list)
        for i,j,k in rides:
            g[j].append((i,j-i+k))
        @cache
        def dfs(i):
            if i==1:return 0
            ans=dfs(i-1)
            for i,k in g[i]:
                ans=max(ans,dfs(i)+k)
            return ans
        return dfs(n)