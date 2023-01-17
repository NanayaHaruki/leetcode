class Solution:
    def countNicePairs(self, nums: List[int]) -> int:
        '''nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) 的(i,j)对个数'''
        def rev(k):
            return int(str(k)[::-1])
        n = len(nums)
        d={}
        ans=0
        mod=int(1e9+7)
        for i in range(n):
            x=nums[i]-rev(nums[i])
            if x in d:               
                ans+=d[x]
                d[x]+=1
            else:
                d[x]=1
        return ans%mod