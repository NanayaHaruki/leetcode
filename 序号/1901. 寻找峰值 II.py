class Solution:
    def findPeakGrid(self, mat: List[List[int]]) -> List[int]:
        # 找任意峰值，爬坡法，最坏情况m*n
        rows,cols=len(mat),len(mat[0])
        def top(i,j):
            print(i,j)
            # 找周围最大值，移动过去
            ai,aj=i,j
            l=-1 if j==0 else mat[i][j-1]
            if l>mat[ai][aj]:
                ai,aj=i,j-1
            r=-1 if j==cols-1 else mat[i][j+1]
            if r>mat[ai][aj]:
                ai,aj=i,j+1
            t=-1 if i==0 else mat[i-1][j]
            if t>mat[ai][aj]:
                ai,aj=i-1,j
            b=-1 if i==rows-1 else mat[i+1][j]
            if b>mat[ai][aj]:
                ai,aj=i+1,j
            return [i,j] if ai==i and aj==j else top(ai,aj)

        return top(0,0)

    def findPeakGrid(self, mat: List[List[int]]) -> List[int]:
        # 找任意峰值
        # 二分列，在这一列中找最大值，判断左右两边大小，继续二分
        rows,cols=len(mat),len(mat[0])
        l,r=-1,cols
        while l+1<r:
            m=(l+r)//2
            mxRow = 0
            for i in range(rows):
                if mat[i][m]>mat[mxRow][m]:
                    mxRow=i
            if m==0:
                if cols==1 or mat[mxRow][m]>mat[mxRow][1]:
                    return [mxRow,0]
                else:
                    l=m
            elif m==cols-1:
                if cols==1 or mat[mxRow][m]>mat[mxRow][m-1]:
                    return [mxRow,m]
                else:
                    r=m
            else:
                if mat[mxRow][m-1]>mat[mxRow][m]:
                    r=m
                elif mat[mxRow][m+1]>mat[mxRow][m]:
                    l=m
                else:
                    return [mxRow,m]