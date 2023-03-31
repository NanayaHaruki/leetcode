class Solution: 
    def highestRankedKItems(
        self, grid: List[List[int]], pricing: List[int], start: List[int], k: int
    ) -> List[List[int]]:       
        '''从start bfs 遍历能够经过的每一点，将满足价格区间的插入堆中，同时保证集合大小不超过k'''
        ans=[]
        direction = [[-1,0],[1,0],[0,1],[0,-1]]
        mnP,mxP = pricing
        m,n=len(grid),len(grid[0])
        q = deque([start])        
        r,c=start       
        if mnP<=grid[r][c]<=mxP:
            ans.append([0,grid[r][c],r,c])       
        grid[r][c]=0
        step = 0
        while q:
            sz = len(q)
            step+=1
            for _ in range(sz):
                r,c=q.popleft()           

                # 添加下一步能走的位置
                for diffR,diffC in direction:
                    newR,newC = r+diffR,c+diffC
                    if 0<=newR<m and 0<=newC<n and grid[newR][newC]>0:
                        q.append([newR,newC])
                        if mnP<=grid[newR][newC]<=mxP:
                            # 处理答案集合
                            ans.append([step,grid[newR][newC],newR,newC])
                        grid[newR][newC]=0
            if len(ans)>=k:break # 因为距离是第一优先级，当前距离的点的数量已经超过k了，后面不需要再考虑
        ans.sort()
        return [ [r,c]for _,_,r,c in ans[:k]]