class Solution:
    def countAlternatingSubarrays(self, nums: List[int]) -> int:
        @cache
        def dfs(i):
            if i==0:return 1
            return 1 if nums[i]==nums[i-1] else dfs(i-1)+1
        return sum(dfs(x) for x in range(len(nums)))