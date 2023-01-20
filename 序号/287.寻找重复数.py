class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        nums.sort()
        # 有重复的数，本该5的位置只能到4，说明重复数在左边。位置正常说明在右边
        l,r=0,len(nums)
        while l+1<r:
            m=(l+r)//2
            cnt=0
            for i in nums:
                if i<=m:
                    cnt+=1
            if cnt<=m:
                l=m
            else:
                r=m
        return r