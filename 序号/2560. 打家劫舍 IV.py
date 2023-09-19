class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        '''至少偷k个房，单个房最大值为x，求x最小值'''
        mx=max(nums)
        l,r=0,mx+1
        def rob(x):
            i=cnt=0
            while i<len(nums):
                if nums[i]>x:
                    i+=1
                else:
                    i+=2
                    cnt+=1
                if cnt>=k:return True
            return False

        while l+1<r:
            mid=(l+r)//2
            if rob(mid):
                r=mid
            else:
                l=mid
        return r