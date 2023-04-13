class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        # dfs
        m,n=len(image),len(image[0])
        oc=image[sr][sc]
        def dfs(r,c):
            if r<0 or r>=m or c<0 or c>=n or image[r][c]!=oc or image[r][c]==color:
                return 
            image[r][c]=color
            dfs(r+1,c)
            dfs(r-1,c)
            dfs(r,c+1)
            dfs(r,c-1)
        dfs(sr,sc)
        return image


        # bfs
        # m,n=len(image),len(image[0])
        # q=deque([(sr,sc)])
        # originColor=image[sr][sc]
        # image[sr][sc]=color
        # directions=[[0,1],[0,-1],[1,0],[-1,0]]
        # while q:
        #     sz=len(q)
        #     for _ in range(sz):
        #         r,c = q.popleft()
        #         print(f'{r} {c}')
        #         for diffX,diffY in directions:
        #             newR,newC=r+diffX,c+diffY
        #             if 0<=newR<m and 0<=newC<n and image[newR][newC]==originColor:
        #                 image[newR][newC]=color
        #                 q.append((newR,newC))
        # return image