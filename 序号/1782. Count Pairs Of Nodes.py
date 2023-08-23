class Solution:
    def countPairs(self, n: int, edges: List[List[int]], queries: List[int]) -> List[int]:
        t=[0]*(n+1) # t[i] 表示与i连接的边的数量
        cntEdges = Counter()
        for a,b in edges:
            t[a]+=1
            t[b]+=1
            if a>b:a,b=b,a
            cntEdges[(a,b)]+=1
        # 计算t中有多少点之和能大于q，双指针
        st=sorted(t)
        ans=[0]*len(queries)
        for i,q in enumerate(queries):
            l,r=1,n
            while l<r:
                if st[l]+st[r]<=q:
                    l+=1
                else:
                    ans[i]+=r-l
                    r-=1
            for (a,b),c in cntEdges.items():
                if q<t[a]+t[b]<=q+c:
                    ans[i]-=1
        return ans