class Solution:
    def numberOfRightTriangles(self, grid: List[List[int]]) -> int:
        m,n=len(grid),len(grid[0])
        r=[set() for _ in range(m)]
        c=[set() for _ in range(n)]
        st = set()
        for i,row in enumerate(grid):
            for j,x in enumerate(row):
                if x==1:
                    r[i].add(j)
                    c[j].add(i)
                    st.add((i,j))
        ans=0
        for i,j in st:
            ans+=(len(r[i])-1)*(len(c[j])-1)
        return ans
        