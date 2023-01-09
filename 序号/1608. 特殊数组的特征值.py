class Solution:
    def specialArray(self, nums: List[int]) -> int:
        nums.sort()
        n=len(nums)
        l,r=0,n # 数组长度最大100
        while l<=r:
            m=(l+r)>>1
            idx = bisect.bisect_left(nums,m)
            overM = n-idx
            if overM==m:
                return m
            elif overM<m:
                r=m-1
            else :
                l=m+1
        return -1