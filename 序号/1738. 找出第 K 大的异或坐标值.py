class Solution:
    def kthLargestValue(self, matrix: List[List[int]], k: int) -> int:
        m,n=len(matrix),len(matrix[0])
        f=[[0]*(n+1) for _ in range(m+1)]
        q = []
        for i in range(m):
            for j in range(n):
                f[i+1][j+1]=f[i][j+1] ^ f[i+1][j] ^ f[i][j] ^ matrix[i][j]
                if len(q)<k:
                    heappush(q,f[i+1][j+1])
                else:
                    heappushpop(q,f[i+1][j+1])
        return min(q)
