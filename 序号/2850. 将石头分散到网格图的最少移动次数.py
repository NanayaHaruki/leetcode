class Solution:
    def minimumMoves(self, grid: List[List[int]]) -> int:
        a = []
        b=[]
        for i,row in enumerate(grid):
            for j,x in enumerate(row):
                if x==0:
                    b.append((i,j))
                elif x>1:
                    a+=[(i,j)]*(x-1)
        ans = inf
        for aa in permutations(a):
            cur = 0
            for (ax,ay),(bx,by) in zip(aa,b):
                cur+=abs(ax-bx)+abs(ay-by)
            ans = min(ans,cur)
        return ans
