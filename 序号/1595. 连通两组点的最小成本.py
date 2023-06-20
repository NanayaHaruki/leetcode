class Solution:
    def connectTwoGroups(self, cost: List[List[int]]) -> int:
        m,n=len(cost),len(cost[0]) # a\b 两个组的长度
        min_cost=[math.inf]*n
        for j in range(n):
            for i in range(m):
                min_cost[j]=min(min_cost[j],cost[i][j])
                
        @cache
        def dfs(i,unlink):
            ''' a组中[0,i] 与b组连接，且b组中有unlink还未连接的最小成本 '''
            if i==m: # a组查完了，b组检查最小成本
                ans=0
                for j in range(n):
                    if unlink>>j&1:
                        ans+=min_cost[j]
                return ans
            ans=math.inf
            for j in range(n): # 让i与每个b组元素都连接下
                ans=min(ans,cost[i][j]+dfs(i+1,unlink&~(1<<j)))
            return ans
        return dfs(0,(1<<n)-1)