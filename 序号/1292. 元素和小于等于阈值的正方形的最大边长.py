class Solution:
    def maxSideLength(self, mat: List[List[int]], threshold: int) -> int:
        # 求元素和小于阈值的最大边长
        # 不断二分边长，遍历矩阵查看能否满足条件
        # 用前缀和加速计算正方形元素和
        rows,cols=len(mat),len(mat[0])
        ps=[[0]*(cols+1) for _ in range(rows+1)] # ps[i][j] 保存[0,0]到[i,j]的总和
        for i in range(1,rows+1):
            for j in range(1,cols+1):
                ps[i][j]=ps[i-1][j]+ps[i][j-1]-ps[i-1][j-1]+mat[i-1][j-1]
        l,r=0,min(rows,cols)+1

        def check(k):
            for i in range(k,rows+1):
                for j in range(k,cols+1):
                    if ps[i][j]-ps[i-k][j]-ps[i][j-k]+ps[i-k][j-k]<=threshold:
                        return True
            return False

        while l+1<r:
            m=(l+r)//2
            if check(m):
                l=m
            else:
                r=m
        return l