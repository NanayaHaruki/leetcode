class Solution:
    def countSquares(self, f: List[List[int]]) -> int:
        # 如果(i,j)是正方形右下角，定义f[i][j]为这个正方形的最大边，同时也是以(i,j)为右下角的正方形的数量
        # 左边\上面\左上 三个点为右下角的最大正方形为0，则以(i,j)为右下角的正方形最大边只能是1
        # 三方向最大正方形为中最少为1时，则f[i][j]可以扩大到2，由此可见，f[i][j]的值取决于三个方向中的最小值
        m,n=len(f),len(f[0])
        ans=0
        for i in range(1,m):
            for j in range(1,n):
                if f[i][j]!=1:continue
                f[i][j]=min(f[i-1][j],f[i][j-1],f[i-1][j-1])+1
        return sum(sum(x) for x in f)

        # # 先用前缀和统计矩形范围和，就可以在o1时间知道某个矩阵合适否
        # m,n=len(matrix),len(matrix[0])
        # s=[[0]*(n+1) for _ in range(m+1)]
        # for i in range(m):
        #     for j in range(n):
        #         s[i+1][j+1]=s[i][j+1]+s[i+1][j]-s[i][j]+matrix[i][j]
        # # 在从小到大统计满足的矩阵个数，如果某个大小的正方形不存在，则更大的也不存在了
        # def check(a:int):
        #     target = a*a
        #     ans=0
        #     for i2 in range(a-1,m):
        #         for j2 in range(a-1,n):
        #             i1,j1=i2-a+1,j2-a+1
        #             area = s[i2+1][j2+1]-s[i1][j2+1]-s[i2+1][j1]+s[i1][j1]
        #             if area==target:
        #                 ans+=1
        #     return ans
        # ans=0
        # for i in range(1,min(m,n)+1):
        #     c =check(i)
        #     # if c==0:break
        #     ans+=c
        # return ans
