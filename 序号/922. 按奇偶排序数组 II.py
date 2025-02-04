class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        l,r,n=0,0,len(nums)
        while l<n: # l 左边都是排好的，r往后找有问题的位置，要么是与l相同的问题，这问题会在l走到时修复;要么就是可以和l交换的位置
            if l&1:
                if nums[l]&1:
                    l+=1
                else:
                    if r<=l:r=l+1
                    # 找偶数位置，值为奇数的
                    if r&1: r+=1
                    while r<n and nums[r]%2==0:
                        r+=2
                        continue
                    nums[l],nums[r]=nums[r],nums[l]
                    l+=1
            else:
                if nums[l]%2==0:
                    l+=1
                else:
                    if r<=l:r=l+1
                    if r%2==0:r+=1
                    while r<n and nums[r]&1:
                        r+=2
                        continue
                    nums[l],nums[r]=nums[r],nums[l]
                    l+=1
        return nums
