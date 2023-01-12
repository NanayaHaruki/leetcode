class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        # 题设保证了至少是半欧拉图    
        def dfs(u):
            while d[u]:
                v = heapq.heappop(d[u])
                dfs(v)
            ans.append(u)

        ans=[]
        # 建表
        d=defaultdict(list)
        for u,v in tickets:
            heapq.heappush(d[u],v)
        dfs('JFK')
        ans.reverse()
        return ans