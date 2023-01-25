class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # 从右上角开始遍历，相当于遍历bst，左树（同一行左边的都是小于当前值的），右树（当前列下方的都是大于当前值的）
        m,n=len(matrix),len(matrix[0])
        i,j=0,n-1
        while i<m and j>=0:
            if matrix[i][j]==target:
                return True
            if matrix[i][j]>target:
                j-=1
            else:
                i+=1
        return False
    # '''二分 时间O(mlog(n))'''
    # def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    #     m,n=len(matrix),len(matrix[0])
    #     for i in range(m):
    #         l,r=-1,n
    #         while l+1<r:
    #             mid=(l+r)//2
    #             if matrix[i][mid]==target:
    #                 return True
    #             if matrix[i][mid]<target:
    #                 l=mid
    #             else:
    #                 r=mid
    #     return False