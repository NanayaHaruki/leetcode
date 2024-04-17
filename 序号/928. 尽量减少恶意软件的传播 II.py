class UF:
    def __init__(self,n):
        self.p=[i for i in range(n)]
        self.sz=[1]*n

    def find(self,x):
        if self.p[x]!=x:
            self.p[x]=self.find(self.p[x])
        return self.p[x]

    def union(self,a,b):
        pa,pb = self.find(a),self.find(b)
        if pa==pb:return
        self.p[pa]=pb
        self.sz[pb]+=self.sz[pa]

class Solution:
    def minMalwareSpread(self, graph: List[List[int]], initial: List[int]) -> int:
        # 建新图，不带病毒玩，先将其他的链接起来
        n = len(graph)
        virus = set(initial)
        uf = UF(n)
        for i in range(n):
            if i in virus:continue
            for j in range(n):
                if j in virus:continue
                if graph[i][j]==1:
                    uf.union(i,j)
        # 根据原图中，病毒与哪些点连接，统计这些点会被几个病毒传染。
        # 只有会被一个病毒传染的干净点，删除病毒时，这个链接块的大小才是删除的有效值
        cnts = [0]*n # 记录一个点被几个病毒连接
        d = defaultdict(set) # 记录一个病毒与哪些联通块 有连接
        for i in initial:
            for j in range(n):
                if graph[i][j]==1 and j not in virus:
                    d[i].add(uf.find(j))
            for c in d[i]:
                cnts[c]+=1
        mnIdx = mnSz = -1
        for virus,cleans in d.items():
            # k 是病毒，v是与k连接的干净块的顶节点的集合
            print(virus,len(cleans))
            sz=0
            for c in cleans:
                if cnts[c]==1:
                    sz+=uf.sz[c]
            if sz>mnSz or (sz==mnSz and virus<mnIdx):
                mnIdx,mnSz=virus,sz
        return mnIdx

        