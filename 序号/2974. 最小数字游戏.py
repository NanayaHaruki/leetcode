class Solution:
    def numberGame(self, nums: List[int]) -> List[int]:
        nums.sort()
        n = len(nums)
        ans = []
        for i in range(1,n,2):
            ans.append(nums[i])
            ans.append(nums[i-1])
        return ans