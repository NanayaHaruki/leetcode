class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        n = len(candidates)
        candidates.sort()
        ans = []
        cur = []
        def dfs(i,remain):        
            if remain==0:
                ans.append(list(cur))
                return
            if i==n:return 
            for j in range(i,n):
                if candidates[j]>remain:return
                if j>i and candidates[j]==candidates[j-1]:continue
                cur.append(candidates[j])
                dfs(j+1,remain-candidates[j])
                cur.pop()
       
        dfs(0,target)
        return ans