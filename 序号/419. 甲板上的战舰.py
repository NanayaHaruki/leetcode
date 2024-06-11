class UF:
    def __init__(self,n):
        self.p=[i for i in range(n)]
    

    def union(self,x,y):
        px,py = self.find(x),self.find(y)
        if px!=py:
            self.p[py]=px

    def find(self,x):
        if self.p[x]!=x:
            self.p[x]=self.find(self.p[x])
        return self.p[x]



class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        m ,n = len(board),len(board[0])
        uf = UF(m*n)

        def t(x,y):
            return x*n+y
        
        st = set()
        for i in range(m):
            for j in range(n):
                x = board[i][j]
                if x!='X':continue
                if i>0 and board[i-1][j]=='X':
                    uf.union(t(i-1,j),t(i,j))
                if j>0 and board[i][j-1]=='X':
                    uf.union(t(i,j-1),t(i,j))
                st.add(uf.find(t(i,j)))
        return len(st)
                