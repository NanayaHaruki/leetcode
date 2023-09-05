class Solution:
    def minNumber(self, nums1: List[int], nums2: List[int]) -> int:
        # 找重复的数字中最小的; 没有再分别找最小的
        s2=set(nums2)
        a=10
        for x in nums1:
            if x in s2 and x<a:
                a=x
        if a<10:return a
        a,b=min(nums1),min(nums2)
        if a>b:a,b=b,a
        return a*10+b