class Solution:
    def minMaxGame(self, nums: List[int]) -> int:
        n = len(nums)
        while n>1:
            n//=2
            newNs = [0]*n
            for i in range(n):
                if i&1:
                    newNs[i]=max(nums[i*2],nums[i*2+1])
                else:
                    newNs[i]=min(nums[i*2],nums[i*2+1])
            nums=newNs
        return nums[0]