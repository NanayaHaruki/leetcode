class Solution:
    def findPeakGrid(self, mat: List[List[int]]) -> List[int]:
        # 找任意峰值，爬坡法，最坏情况m*n
        m, n = len(mat), len(mat[0])

        dirs = (-1,0,1,0,-1)
        def v(i,j):
            if 0<=i<m and 0<=j<n:return mat[i][j]
            return -1
        def dfs(i,j):
            if v(i,j) > v(i+1,j) and v(i,j)>v(i-1,j) and v(i,j)>v(i,j-1) and v(i,j)>v(i,j+1):return [i,j]
            for idx in range(4):
                dx,dy=dirs[idx],dirs[idx+1]
                nx,ny=i+dx,j+dy
                if 0<=nx<m and 0<=ny<n and mat[nx][ny]>mat[i][j]:
                    return dfs(nx,ny)
        return dfs(0,0)

        # rows,cols=len(mat),len(mat[0])
        # def top(i,j):
        #     print(i,j)
        #     # 找周围最大值，移动过去
        #     ai,aj=i,j
        #     l=-1 if j==0 else mat[i][j-1]
        #     if l>mat[ai][aj]:
        #         ai,aj=i,j-1
        #     r=-1 if j==cols-1 else mat[i][j+1]
        #     if r>mat[ai][aj]:
        #         ai,aj=i,j+1
        #     t=-1 if i==0 else mat[i-1][j]
        #     if t>mat[ai][aj]:
        #         ai,aj=i-1,j
        #     b=-1 if i==rows-1 else mat[i+1][j]
        #     if b>mat[ai][aj]:
        #         ai,aj=i+1,j
        #     return [i,j] if ai==i and aj==j else top(ai,aj)
        # return top(0,0)

    def findPeakGrid(self, mat: List[List[int]]) -> List[int]:
        # 找任意峰值
        # 二分列，在这一列中找最大值，判断左右两边大小，继续二分
        # 第i行的最大值为mat[i,j]=10，若mat[i+1][j]>10,假设是11吧，则比i大的行中，必然有峰值，因为这条路径都>10,不可能穿过i行跑到上面去
        # 同理，若mat[i+1][j]<10,要么10本身是峰值，要么峰值在上面，如此就可以二分行的坐标进行查询了
        m,n=len(mat),len(mat[0])
        l,r=-1,m+1

        def findMaxIndex(arr):
            value,idx=arr[0],0
            for i in range(1,len(arr)):
                if arr[i]>value:
                    value=arr[i]
                    idx=i
            return idx
        while l+1<r:
            mid=(l+r)//2
            if mid==m-1:
                r=mid
                continue
            j=findMaxIndex(mat[mid])
            if mat[mid][j]>mat[mid+1][j]:
                r=mid
            else:
                l=mid
        return [r,findMaxIndex(mat[r])]
    
        # rows,cols=len(mat),len(mat[0])
        # l,r=-1,cols
        # while l+1<r:
        #     m=(l+r)//2
        #     mxRow = 0
        #     for i in range(rows):
        #         if mat[i][m]>mat[mxRow][m]:
        #             mxRow=i
        #     if m==0:
        #         if cols==1 or mat[mxRow][m]>mat[mxRow][1]:
        #             return [mxRow,0]
        #         else:
        #             l=m
        #     elif m==cols-1:
        #         if cols==1 or mat[mxRow][m]>mat[mxRow][m-1]:
        #             return [mxRow,m]
        #         else:
        #             r=m
        #     else:
        #         if mat[mxRow][m-1]>mat[mxRow][m]:
        #             r=m
        #         elif mat[mxRow][m+1]>mat[mxRow][m]:
        #             l=m
        #         else:
        #             return [mxRow,m]