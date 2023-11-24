class Solution:
    def countPairs(self, nums: List[int], target: int) -> int:
        nums.sort()
        ans=0
        for i,x in enumerate(nums):
            # 如果是负数 就没问题 
            # if x>=target//2:
            #     break
            
            j=bisect.bisect_left(nums,target-x)
            if j-i-1>0:
                ans+=j-i-1
        return ans