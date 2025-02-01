'''
25/02/01
'''
class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        l,r = -1,len(nums)
        while l+1<r:
            m = (l+r)//2
            if nums[m]==target:return True
            if nums[m]==nums[r-1]:r-=1
            elif nums[m]>nums[r-1]:
                if target<nums[m] and target>nums[r-1]:
                    r=m
                else:
                    l=m
            else:
                if target>nums[r-1] or target<nums[m]:
                    r=m
                else:
                    l=m
        return False


class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        n=len(nums)
        # 找中断点
        l,r=-1,n
        while l+1<r:
            m=(l+r)//2
            if nums[m]==target:
                return True
            if nums[m]<nums[r-1]: # 当前在右半部分
                if target>nums[m] and target<=nums[r-1]: # 目标值也在右半部分 且更大
                    l=m
                else: # 目标值在右边但比当前值小 或 目标值在左边
                    r=m
            elif nums[m]>nums[r-1]:
                if target<nums[m] and target>=nums[l+1]:
                    r=m
                else :
                    l=m
            else:
                r-=1
        return False