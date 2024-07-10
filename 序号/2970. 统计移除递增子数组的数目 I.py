class Solution:
    def incremovableSubarrayCount(self, nums: List[int]) -> int:
        n = len(nums)
        ans=0
        for subLen in range(1,n+1):
            for j in range(subLen,n+1):
                p = 0
                ok = True
                for i in range(j-subLen):
                    if nums[i]>p:
                        p=nums[i]
                    else:
                        ok = False
                        break
                if not ok:continue
                for i in range(j,n):
                    if nums[i]>p:
                        p=nums[i]
                    else:
                        ok=False
                        break
                if ok:
                    ans+=1
        return ans