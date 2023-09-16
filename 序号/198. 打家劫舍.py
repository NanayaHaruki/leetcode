class Solution:
    def rob(self, nums: List[int]) -> int:
        stolen,not_stolen=nums[0],0
        for i in range(1,len(nums)):
            cur_stolen=max(stolen,not_stolen+nums[i])
            cur_not_stolen=max(stolen,not_stolen)
            stolen,not_stolen=cur_stolen,cur_not_stolen
        return max(stolen,not_stolen)