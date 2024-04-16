class UF:
    def __init__(self, n):
        self.p = [i for i in range(n)]
        self.sz = [1] * n

    def find(self, x):
        if self.p[x] != x:
            self.p[x] = self.find(self.p[x])
        return self.p[x]

    def union(self, a, b):
        pa, pb = self.find(a),self.find(b)
        if pa==pb:return
        self.p[pa] = pb
        self.sz[pb] += self.sz[pa]


class Solution:
    def minMalwareSpread(self, graph: List[List[int]], initial: List[int]) -> int:
        # 一个联通块中，有一个病毒就全部传染
        # 只能删一个病毒节点，如果一个块中有2个病毒，那删一个无意义
        # 找联通块中只有一个病毒的最大联通块，大小相同返回索引小的
        n = len(graph)
        uf = UF(n)
        for i in range(n):
            for j in range(n):
                if i!=j and graph[i][j] == 1:
                    uf.union(i, j)
        d = defaultdict(list)
        for v in initial:
            p = uf.find(v)
            d[p].append(v)

        mnIdx = min(initial) # 狗屎的按最小索引
        p = uf.find(mnIdx)
        findOneVirus = True if len(d[p]) == 1 else False
        mxCnt=uf.sz[p]
        for k, v in d.items():
            if len(v) == 1:
                if not findOneVirus or uf.sz[k] > mxCnt \
                     or (uf.sz[k]==mxCnt and v[0] < mnIdx):
                    mxCnt, mnIdx = uf.sz[k], v[0]

        return mnIdx