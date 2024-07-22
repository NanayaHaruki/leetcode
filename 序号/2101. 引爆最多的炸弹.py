class Solution:
    def maximumDetonation(self, bombs: List[List[int]]) -> int:
        # 每个炸弹爆炸半径不同，如果A爆炸能引发B炸弹，连接A到B的单向边
        # 统计每个炸弹能连接的炸弹，找最大路径长度
        n = len(bombs)
        d=defaultdict(list)
        for i in range(n):
            for j in range(i+1,n):
                if i==j:continue
                x1,y1,r1=bombs[i]
                x2,y2,r2=bombs[j]
                dis = (x1-x2)**2+(y1-y2)**2
                if dis<=r1*r1:
                    d[i].append(j)
                if dis<=r2*r2:
                    d[j].append(i)
        
        def dfs(i):
            vis.add(i)
            ans = 1
            for j in d[i]:
                if j not in vis:
                    ans+=dfs(j)
            return ans
        ans = 0
        vis = set()
        for i in range(n):
            vis.clear()
            ans = max(ans,dfs(i))
        return ans