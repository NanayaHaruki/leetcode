class Solution:
    def countPaths(self, n: int, edges: List[List[int]]) -> int:
        # 找出含有质数的路径数目
        # 最大为n，先计算出范围内的质数
        isPrime = [True]*(n+1)
        primes = []
        for i in range(2,n+1):
            if isPrime[i]:primes.append(i)
            for j in primes:
                if j*i>n:break
                isPrime[j*i]=False
                if i%j==0:break
        isPrime[1]=False
        # 建树
        g=defaultdict(list)
        for a,b in edges:
            g[a].append(b)
            g[b].append(a)
        # f[i] 以i为起点无质数路径最大长度
        f=[0]*(n+1)
        ans=0
        def dfs(node,fa,path):
            path.append(node)
            for nxt in g[node]:
                if nxt!=fa and not isPrime[nxt]:
                    dfs(nxt,node,path)

        for i in range(1,n+1):
            # 找质数
            if not isPrime[i]:continue
            s=0
            # 找与这个质数相连的合数
            for j in g[i]:
                if isPrime[j]:continue
                if f[j]==0:
                    path=[]
                    dfs(j,-1,path)
                    # path 里都是与j连接的合数
                    for k in path:
                        f[k]=len(path)
                ans+= f[j]*s # 从之前的某个合数 路过i，终点为另一个合数
                s+=f[j]
            ans+=s # 从 质数i 出发的路径
        return ans
