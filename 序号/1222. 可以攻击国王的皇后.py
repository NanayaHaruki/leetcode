class Solution:
    def queensAttacktheKing(self, queens: List[List[int]], king: List[int]) -> List[List[int]]:
        g=[[0]*8 for _ in range(8)]
        for x,y in queens:
            g[x][y]=1
        diff=[(-1,-1),(-1,0),(-1,1),(1,1),(1,0),(1,-1),(0,1),(0,-1)]
        ans=[]
        for dx,dy in diff:
            x,y=king
            while 0<=x<8 and 0<=y<8:
                if g[x][y]==1:
                    ans.append([x,y])
                    break
                x,y=x+dx,y+dy
        return ans