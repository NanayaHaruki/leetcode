class Solution:
    def mctFromLeafValues(self, arr: List[int]) -> int:
        # arr表示叶子的值，非叶节点的值为两边子树叶子节点最大值的积，求整树非叶节点之和的最小值
        n=len(arr)
        # 定义f[i][j]为[i,j]作为叶子节点时的 非叶节点最小和
        # 定义g[i][j]为[i,j]范围内，叶子节点最大值
        # f[i][j]=f[i][k]+f[k+1][j]+g[i][k]*g[k+1][j] ,i<=k<=j,因为更新i的数据需要用到k，j比i大的数据，所以要倒序先算出大的
        f=[[0]*n for _ in range(n)]
        g=[[0]*n for _ in range(n)]
        for i in range(n-1,-1,-1):
            g[i][i]=arr[i]
            for j in range(i+1,n): # j == i 没有意义，表示没有非叶节点，初始为0即可
                g[i][j]=max(g[i][j-1],arr[j])
                f[i][j]=min(f[i][k]+f[k+1][j]+g[i][k]*g[k+1][j] for k in range(i,j))
        return f[0][n-1]