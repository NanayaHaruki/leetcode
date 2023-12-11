class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        # dijkstra
        m, n = len(heights), len(heights[0])
        dis=[[math.inf]*n for _ in range(m)]
        dis[0][0]=0
        dirs = (-1, 0, 1, 0, -1)
        q=[(0,0,0)]
        vis=set()
        while q:
            d,x,y=heapq.heappop(q)
            if (x,y) in vis:continue
            for i in range(4):
                dx,dy =dirs[i],dirs[i+1]
                nx,ny=x+dx,y+dy
                
                if 0<=nx<m and 0<=ny<n :
                    newdis = max(d,abs(heights[x][y]-heights[nx][ny]))
                    if  dis[nx][ny]> newdis:
                        dis[nx][ny]=newdis
                        heapq.heappush(q,(newdis,nx,ny))
        return dis[-1][-1]
    
        # 二分，只允许通过x的路径，如果能到达终点，则不断二分x
        # m, n = len(heights), len(heights[0])
        # if m==1 and n==1:return 0
        # dirs = (-1, 0, 1, 0, -1)
        
        # def bfs(limit):
        #     q = deque([(0,0)])
        #     vis={(0,0)}
        #     while q:
        #         x,y = q.popleft()
        #         for i in range(4):
        #             dx,dy=dirs[i],dirs[i+1]
        #             nx,ny=x+dx,y+dy
        #             if 0<=nx<m and 0<=ny<n and (nx,ny) not in vis and abs(heights[x][y]-heights[nx][ny])<=limit:
        #                 if nx==m-1 and ny==n-1:return True
        #                 q.append((nx,ny))
        #                 vis.add((nx,ny))
        #     return False

        # l,r=-1,10**6+1
        # while l+1<r:
        #     mid=(l+r)//2
        #     if bfs(mid):
        #         r=mid
        #     else:
        #         l=mid
        # return r