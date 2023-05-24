class Solution:
    def frogPosition(
        self, n: int, edges: List[List[int]], t: int, target: int
    ) -> float:
        d = [[] for _ in range(n + 1)]
        for a, b in edges:
            d[a].append(b)
            d[b].append(a)
        vis = set([1])
        ans = [0] * (n + 1)  # 存放每个点在当前时间，青蛙出现的概率
        ans[1] = 1
        def bs(cur,time):
            if not time:
                return
            nextList = [x for x in d[cur] if x not in vis]
            sz=len(nextList)
            if sz==0:
                return
            for x in nextList:
                ans[x]+=ans[cur]/sz
                vis.add(x)
                bs(x,time-1)
                vis.remove(x)
            ans[cur]=0
        bs(1,t)
        return ans[target]