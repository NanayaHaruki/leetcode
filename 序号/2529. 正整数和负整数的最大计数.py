class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        neg = bisect_left(nums,0)
        notP = bisect_right(nums,0)
        return max(neg,len(nums)-notP)
        # O(N)
        # p=n=0
        # for x in nums:
        #     if x>0:p+=1
        #     elif x<0:n+=1
        # return max(p,n)