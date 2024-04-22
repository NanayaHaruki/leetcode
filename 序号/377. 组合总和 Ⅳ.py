class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        @cache
        def dfs(t):
            if t<0:return 0
            if t==0:return 1
            ans=0
            for x in nums:
                ans+=dfs(t-x)
            return ans
        return dfs(target)
