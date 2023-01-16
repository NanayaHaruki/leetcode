class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # 贪心二分
        # 维护一个list，来个新数字，如果比最后一个大，可以加在list后面，长度+1
        # 如果来个数字比list中最大的那个小，长度不变，但是可以找list中比他大的第一个，替换掉，让list中的元素涨的慢一点
        list=[nums[0]]
        n=len(nums)
        for i in range(1,n):
            if nums[i]>list[-1]:
                list.append(nums[i])
            else:
                l,r=-1,len(list)
                while l+1<r:
                    m = (l+r)//2
                    if list[m]<nums[i]:
                        l=m
                    else:
                        r=m
                list[r]=nums[i]
        return len(list)