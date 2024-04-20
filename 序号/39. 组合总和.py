class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # 排序后，通过回溯往里塞，超过target就跳过
        candidates.sort()
        n=len(candidates)
        ans=[]
        tmp = []
        def dfs(i,remain):
            if i==n:
                return
            if remain==0:
                ans.append(tmp[::])
                return
            for j in range(i,n):
                if remain<candidates[j]:break
                tmp.append(candidates[j])
                dfs(j,remain-candidates[j])
                tmp.pop()
        dfs(0,target)
        return ans