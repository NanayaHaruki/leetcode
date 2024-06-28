class Solution:
    def paintWalls(self, cost: List[int], time: List[int]) -> int:
        # 将time分成2组，A组的值大于B的个数。
        # A组cost和最低
        # 0-1背包，考虑每面墙，付费的人刷不刷
        # 付费刷的时间>=免费刷的个数=n-付费刷了几面墙
        # 付费刷的时间+付费刷的次数 >=n
        n = len(time)
        @cache
        def dfs(i,j): # i是前多少面墙，j是剩余的 付费刷的时间+付费刷的次数
            if j<=0:return 0
            if i<0:return inf
            return min(dfs(i-1,j),dfs(i-1,j-time[i]-1)+cost[i])
        return dfs(n-1,n)
        