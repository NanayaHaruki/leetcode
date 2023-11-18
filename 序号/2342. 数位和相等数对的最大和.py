class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        d={}
        for x in nums:
            sm=0
            xx=x
            while x:
                sm+=x%10
                x//=10
            if sm not in d:
                d[sm]=[xx]
            else:
                d[sm].append(xx)
        ans=-1
        for k,v in d.items():
            if len(v)<2:continue
            v.sort()
            ans=max(ans,v[-1]+v[-2])
        return ans
