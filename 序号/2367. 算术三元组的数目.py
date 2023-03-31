class Solution:
    def arithmeticTriplets(self, nums: List[int], diff: int) -> int:
        st = set(nums)
        n=len(nums)
        ans=0
        for i in range(1,n-1):
            if nums[i]-diff in st and nums[i]+diff in st:
                ans+=1
        return ans
