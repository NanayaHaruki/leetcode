class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n==1:return [0]
        # 找哪些节点为根，树的高度最小
        d = defaultdict(set)
        for a,b in edges:
            d[a].add(b)
            d[b].add(a)
        q = deque()
        for u in d:
            if len(d[u])==1:q.append(u)
        while q:
            ans=[]
            for _ in range(len(q)):
                u = q.popleft() # 度为1的点作为叶，找到连接向叶的，删掉它
                ans.append(u)
                for v in d[u]:
                    d[v].remove(u)
                    if len(d[v])==1:q.append(v)
        return ans