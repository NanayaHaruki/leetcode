class UF:
    def __init__(self,n) -> None:
        self.p=list(range(n))

    def union(self,a,b):
        pa,pb=self.find(a),self.find(b)
        self.p[pa]=pb

    def find(self,a):
        if self.p[a]!=a:
            self.p[a]=self.find(self.p[a])
        return self.p[a]

class Solution:
    def matrixRankTransform(self, matrix: List[List[int]]) -> List[List[int]]:
        '''返回矩阵的秩'''
        # 存储相同值的行列 key为值 value为[(row1,col1),(row2,col2)]
        d=defaultdict(list) 
        rows,cols=len(matrix),len(matrix[0])
        cntR,cntC=[0]*rows,[0]*cols
        ans=[[0 for _ in range(cols)] for _ in range(rows)]
        for r in range(rows):
            for c in range(cols):
                d[matrix[r][c]].append((r,c))
        for k in sorted(d):
            uf = UF(rows+cols)
            rank=defaultdict(int)
            for r,c in d[k]:
                uf.union(r,c+rows) # 总共有rows行，cols列，最多需要联通的项有rows+cols项，将col0 当做m，colsI当做m+i项
            for r,c in d[k]:
                pr = uf.find(r)
                rank[pr]=max(rank[pr],cntR[r],cntC[c])
            for r,c in d[k]:
                ans[r][c]=cntC[c]=cntR[r]=rank[uf.find(r)]+1
        return ans