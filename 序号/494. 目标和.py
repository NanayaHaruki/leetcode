class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        s = sum(nums)-abs(target)
        if s<0 or s%2:return 0
        target =s//2
        # 从nums中选出和为target的数量
        @cache
        def dfs(i,t): # 前i个数，组成和为t的数量
            if t<0:
                return 0
            if i<0:
                return 1 if t==0 else 0
            if t<nums[i]:
                return dfs(i-1,t)
            return  dfs(i-1,t)+dfs(i-1,t-nums[i])
        return dfs(len(nums)-1,target)