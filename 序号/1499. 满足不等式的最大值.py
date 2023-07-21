class Solution:
    def findMaxValueOfEquation(self, points: List[List[int]], k: int) -> int:
        # x 递增，找两个点 y1+y2+x2-x1 最大，x2-x1<=k.
        # 需要维护 y-x 最大，单调队列，来个新点，计算y-x，将队列中y-x更小的点弹出去
        q=deque()
        ans=-math.inf
        for x,y in points:
            # 超过k的先移出队列
            while q and x-q[0][0]>k:
                q.popleft()
            # q[0]为 最小的x了，更新答案
            if q:
                ans=max(ans,x-q[0][0]+y+q[0][1])
            # 将当前点 压入队列
            while q and q[-1][1]-q[-1][0]<y-x:
                q.pop()
            q.append((x,y))
        return ans