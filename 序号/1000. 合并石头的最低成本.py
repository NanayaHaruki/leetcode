class Solution:
    def mergeStones(self, stones: List[int], k: int) -> int:
        ps=list(itertools.accumulate(stones,initial=0)) # ps[i] 表示stones[i]前面所有数之和（不含i）
        n=len(stones)
        if (n-1)%(k-1):
            return -1
        @cache  # [i,j]堆成p堆需要的成本
        def dfs(i, j, p):
            if p==1:
                if i==j:
                    return 0 # 本身就是一堆，无成本
                else:
                    return dfs(i,j,k)+ps[j+1]-ps[i] # 将k堆合并成一堆的成本，用前缀和求出
            else:
                mn=int(1e9)
                for x in range(i,j,k-1):
                    mn=min(dfs(i,x,1)+dfs(x+1,j,p-1),mn)
                return mn
        return dfs(0,n-1,1)