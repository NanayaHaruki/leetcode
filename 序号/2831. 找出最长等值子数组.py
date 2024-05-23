class Solution:
    def longestEqualSubarray(self, nums: List[int], k: int) -> int:
        sortedlist = sorted((x,i) for i,x in enumerate(nums))
        ans=l=r=0
        n=len(nums)
        while r< n:
            if sortedlist[r][0]!=sortedlist[l][0]:
                l=r
                r+=1
                continue
            n_val = r-l+1
            n_total=sortedlist[r][1]-sortedlist[l][1]+1
            if n_total-n_val<=k:
                ans=max(ans,n_val)
                r+=1
            else:
                l+=1
        return ans