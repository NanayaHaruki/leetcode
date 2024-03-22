class Solution:
    def minimumVisitedCells(self, grid: List[List[int]]) -> int:
        # 经过几个格子从左上到右下
        # 每个格子都是从上方或左方过来的，用最小堆记录最小的
        m,n = len(grid),len(grid[0])
        row,col=[],[[] for _ in range(n)]
        for i in range(m):
            row.clear()
            for j in range(n):
                x = grid[i][j]
                while row and row[0][1] < j:
                    heapq.heappop(row)
                while col[j] and col[j][0][1] < i:
                    heapq.heappop(col[j])
                ans = 1 if i==0 and j==0 else math.inf # 默认到不了，inf。
                if row: ans=row[0][0]+1
                if col[j]: ans = min(ans,col[j][0][0]+1)
                if x > 0 and ans != math.inf:
                    heapq.heappush(row,(ans,j+x))
                    heapq.heappush(col[j],(ans,i+x))
        return ans if ans != math.inf else -1