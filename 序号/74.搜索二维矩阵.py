class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # 下一行左端比上一行右端大，先对行二分，找到可能在哪一行，再对当前行二分
        row,col=len(matrix),len(matrix[0])
        top,bottom=0,row-1
        while top<=bottom:
            mid = (top+bottom)//2
            if matrix[mid][col-1]<target:
                top=mid+1
            else:
                bottom=mid-1
        if top>=row:
            return False
        left,right=0,col-1
        while left<=right:
            mid=(left+right)//2
            if matrix[top][mid]==target:
                return True
            elif matrix[top][mid]<target:
                left+=1
            else:
                right-=1
        return False