class Solution:
    def rangeSum(self, nums: List[int], n: int, left: int, right: int) -> int:
        ps=list(accumulate(nums))
        mod=int(1e9+7)
        start=0
        n=len(nums)
        for i in range(1,n):
            preNum=nums[i-1]
            oldLen=len(ps)
            for j in range(start+1,oldLen):
                ps.append(ps[j]-preNum)
            start=oldLen
        ps.sort()
        ans=0
        for i in range(left-1,right):
            ans=(ans+ps[i])%mod
        return ans