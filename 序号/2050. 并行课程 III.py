class Solution:
    def minimumTime(self, n: int, relations: List[List[int]], time: List[int]) -> int:
        # relations 表图中每条边的方向 time表时间
        # 拓扑排序  找入度为0的，没有前置课程的
        q = deque()
        g = [[] for _ in range(n+1)]
        ind=[0]*(n+1)
        start=[0]*(n+1) # 前置课程结束后，更新后置课程可以开始的最晚时间
        for u,v in relations:
            g[u].append(v) # 邻接表
            ind[v]+=1 # 统计入度
        
        # 从入度为0的开始 
        for i,x in enumerate(ind):
            if i and x==0:
                q.append((i,0)) # i 定点  0 开始时间
        ans=0
        while q:
            u,t = q.popleft() 
            ans=max(ans,t+time[u-1]) # 开始时间+这门课耗时
            for v in g[u]: # 要先学u，再学v
                start[v]=max(start[v],time[u-1]+t) # v可能有好几个前置课程，保存最晚的
                ind[v]-=1
                if ind[v]==0:
                    q.append((v,start[v]))
        return ans