class Solution:
    def validPartition(self, nums: List[int]) -> bool:
        @cache
        def dfs(i):
            if i==-1:return True
            if i==0 :return False
            if i==1 :return nums[i-1]==nums[i]
            res1 = nums[i-1]==nums[i] and dfs(i-2)
            res2 = nums[i-2]==nums[i-1] and nums[i-1]==nums[i] and dfs(i-3)
            res3 = nums[i-2]+1==nums[i-1] and nums[i-1]+1==nums[i] and dfs(i-3)
            return res1 or res2 or res3
        return dfs(len(nums)-1)