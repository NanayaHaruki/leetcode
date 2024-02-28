class Solution:
    def minIncrements(self, n: int, cost: List[int]) -> int:
        # 每次抹平和兄弟之间的差距就行
        # 由父节点来抹平兄弟
        ans=0
        for i in range(n-1,-1,-1):
            if 2*i+2>=n:continue
            l,r=cost[2*i+1],cost[2*i+2]
            ans+=abs(l-r)
            cost[i]+=max(cost[2*i+1],cost[2*i+2])
        return ans