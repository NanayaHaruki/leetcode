class Solution:
    def maxIncreasingCells(self, mat: List[List[int]]) -> int:
        m,n=len(mat),len(mat[0])
        d={}
        for i in range(m):
            for j in range(n):
                x = mat[i][j]
                if x not in d:
                    d[x]=[(i,j)]
                else:
                    d[x].append((i,j))
        r,c=[0]*m,[0]*n # 存放每行每列已经算出来的最大步数
        for k in sorted(d):
            tmp = []
            for i,j in d[k]: # 避免同值跳跃，先缓存每个点的最大步数
                tmp.append(max(r[i],c[j])+1)
            for idx,p in enumerate(d[k]):
                i,j=p
                r[i]=max(r[i],tmp[idx])
                c[j]=max(c[j],tmp[idx])
        return max(c)