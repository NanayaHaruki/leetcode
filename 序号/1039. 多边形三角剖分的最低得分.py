class Solution:
    def minScoreTriangulation(self, values: List[int]) -> int:
        @cache
        def dfs(i,j):
            if i+1==j:
                return 0
            return min([dfs(i,k)+dfs(k,j)+values[i]*values[j]*values[k] for k in range(i+1,j)])
        return dfs(0,len(values)-1)