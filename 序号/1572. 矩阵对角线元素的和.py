class Solution:
    def diagonalSum(self, mat: List[List[int]]) -> int:
        n=len(mat)
        ans=0
        for i in range(n):
            if i==n-1-i:
                ans+=mat[i][i]
            else:
                ans=ans+mat[i][i]+mat[i][n-1-i]
        return ans