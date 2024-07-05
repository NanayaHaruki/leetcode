class Solution:
    def modifiedMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m,n = len(matrix),len(matrix[0])
        ans = [[0]*n for _ in range(m)]
        mxCol = [0]*n
        for c in range(n):
            mxCol[c] = max(matrix[r][c] for r in range(m))
        for i in range(m):
            for j in range(n):
                if matrix[i][j]==-1:
                    ans[i][j]=mxCol[j]
                else:
                    ans[i][j]=matrix[i][j]
        return ans