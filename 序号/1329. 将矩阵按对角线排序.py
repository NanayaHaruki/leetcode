class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        cache = []
        m,n=len(mat),len(mat[0])
        # 第1个点在第一行，从左往右
        for i in range(n):
            r,c=0,i
            while r<m and c<n:
                cache.append(mat[r][c])
                r,c=r+1,c+1
            cache.sort()
            while cache:
                mat[r-1][c-1]=cache.pop()
                r,c=r-1,c-1
        for i in range(1,m):
            r,c=i,0
            while r<m and c<n:
                cache.append(mat[r][c])
                r,c=r+1,c+1
            cache.sort()
            while cache:
                mat[r-1][c-1]=cache.pop()
                r,c=r-1,c-1
        return mat



