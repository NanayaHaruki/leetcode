

class TreeAncestor:
    # 24/04/06
    def __init__(self, n: int, parent: List[int]):
        # 找到一个节点的第k个祖先，数据量要求logN时间
        # 初始化中就要保留好每个节点的2*x次幂所有祖先才能查询时logN找到，第7个祖先，7的二进制是111，就先找100(4)第4个祖先，再找010第4个祖先的第2个祖先，最后找001
        m=n.bit_length()
        f=[[-1]*m for _ in range(n)]
        for i,p in enumerate(parent):
           f[i][0]=p # 2的0次方是1，表示i的第1个祖先是p
        # 第1个祖先知道了，现在更新所有数的第2个祖先。因为是每一层更新所有数，所以数的遍历放内循环
        # j=0的情况，上面更新过了
        for j in range(m-1): # 一层一层的更新，从第2^0层，更新第2^1=2层,通过第2层祖先更新第2^2=4层祖先
            for i in range(n):
                 # i=j=0,0的第1个祖先是p，0的第2个祖先就是p的第1个祖先 
                 # i=1,j=2,1的第2^2=4个祖先是p，1的第8个祖先就是p的第4个祖先
                p = f[i][j]
                if p ==-1: continue
                f[i][j+1]=f[p][j]   
        self.f = f
                   

    def getKthAncestor(self, node: int, k: int) -> int:
        # 通过k的二进制知道第几位有1，就知道去哪几层找
        ans = node
        while k:
            lowerBit = k&-k # 需要找第4层，第4层在f中存的是f[i][2],lowerbit是100,要找2就将二进制位数-1
            ans = self.f[ans][lowerBit.bit_length()-1]
            if ans==-1:break #找不到，就是没有了
            k^=lowerBit
        return ans
    

    # def __init__(self, n: int, parent: List[int]):
    #     '''
    #     找第k个父节点，比如找第10个，可以先找出第8个父节点，二进制100，再找爷爷节点10即可
    #     初始化出每个节点的二的幂的祖先（父节点（2^0),爷爷节点（2^1),爷爷的爷爷节点（2^2)...)
    #     就能在log(k)时间内找到祖先
    #     '''
    #     m=n.bit_length()
    #     f = [[-1]*m for _ in range(n)] # f[i][j] 为i的第2^个父节点是谁
    #     for i,p in enumerate(parent):
    #         f[i][0]=p
    #     for j in range(m-1): # 先遍历父节点，再遍历爷爷节点
    #         for i in range(n):
    #             p=f[i][j] # i=2,j=3,p为2节点的第8个祖先
    #             if p!=-1:
    #                 f[i][j+1]=f[p][j] # 2的第16个祖先 = 2的第8个祖先p的第8个祖先 
    #     self.f = f

    # def getKthAncestor(self, node: int, k: int) -> int:
    #     f=self.f
    #     while k and ~node: # k存在，继续找祖先; node取反存在，node不是 -1
    #         lb=k&-k
    #         node = f[node][lb.bit_length()-1]
    #         k^=lb
    #     return node



# Your TreeAncestor object will be instantiated and called as such:
# obj = TreeAncestor(n, parent)
# param_1 = obj.getKthAncestor(node,k)