class Solution:
    def maxScore(self, nums: List[int], x: int) -> int:
        n=len(nums)
        @cache 
        def dfs(i,mod):
            if i==n:return 0
            if nums[i]&1 == mod:
                a = dfs(i+1,mod)
                b = dfs(i+1,1-mod)
                return max(a,b-x)+nums[i]
            return dfs(i+1,mod)
        return dfs(0,nums[0]&1)