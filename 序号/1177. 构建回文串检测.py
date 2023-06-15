class Solution:
    def canMakePaliQueries(self, s: str, queries: List[List[int]]) -> List[bool]:
        n=len(s)
        ps=[0]*(n+1)
        for i in range(1,n+1):
            ps[i]=ps[i-1] ^  (1<<(ord(s[i-1])-97))
        ans=[False]*len(queries)
        for i,q in enumerate(queries):
            l,r,k=q
            ans[i] = (ps[r+1]^ps[l]).bit_count()//2 <=k
        return ans