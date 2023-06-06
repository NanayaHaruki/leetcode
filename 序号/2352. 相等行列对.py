class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        # hash python中list不可hash，需转成tuple
        cnt=Counter(tuple(x) for x in grid)
        n=len(grid)
        ans=0
        for i in range(n):
            ans+=cnt[tuple(grid[j][i] for j in range(n))]
        return ans

        # 每行都需要比对所有列，总数n^2,n行总耗时n^3
        # n=len(grid)
        # def eq(rowIndex,colIndex):
        #     ''' '''
        #     for i in range(n):
        #         if grid[rowIndex][i]!=grid[i][colIndex]:
        #             return False
        #     return True
        # ans=0
        # for i in range(n):
        #     for j in range(n):
        #         if eq(i,j):
        #             ans+=1
        # return ans
    