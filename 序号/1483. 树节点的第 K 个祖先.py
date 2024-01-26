class TreeAncestor:

    def __init__(self, n: int, parent: List[int]):
        '''
        找第k个父节点，比如找第10个，可以先找出第8个父节点，二进制100，再找爷爷节点10即可
        初始化出每个节点的二的幂的祖先（父节点（2^0),爷爷节点（2^1),爷爷的爷爷节点（2^2)...)
        就能在log(k)时间内找到祖先
        '''
        m=n.bit_length()
        f = [[-1]*m for _ in range(n)] # f[i][j] 为i的第2^个父节点是谁
        for i,p in enumerate(parent):
            f[i][0]=p
        for j in range(m-1): # 先遍历父节点，再遍历爷爷节点
            for i in range(n):
                p=f[i][j] # i=2,j=3,p为2节点的第8个祖先
                if p!=-1:
                    f[i][j+1]=f[p][j] # 2的第16个祖先 = 2的第8个祖先p的第8个祖先 
        self.f = f

    def getKthAncestor(self, node: int, k: int) -> int:
        f=self.f
        while k and ~node: # k存在，继续找祖先; node取反存在，node不是 -1
            lb=k&-k
            node = f[node][lb.bit_length()-1]
            k^=lb
        return node



# Your TreeAncestor object will be instantiated and called as such:
# obj = TreeAncestor(n, parent)
# param_1 = obj.getKthAncestor(node,k)