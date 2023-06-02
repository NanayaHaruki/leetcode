class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        n=len(words)
        st={'a','e','i','o','u'}
        ps=[0]*(n+1)
        for i,x in enumerate(words):
            ps[i+1]=ps[i]+ (1 if x[0] in st and x[-1] in st else 0)
        ans=[0]*len(queries)
        for i,q in enumerate( queries):
            ans[i]=ps[q[1]+1]-ps[q[0]]
        return ans