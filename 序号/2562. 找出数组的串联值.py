class Solution:
    def findTheArrayConcVal(self, nums: List[int]) -> int:
        ans=0
        n=len(nums)
        for l in range(n):
            r=n-1-l
            if l<r:
                ans+=int(str(nums[l])+str(nums[r]))
            elif l==r:
                ans+=nums[l]
            else: break
            print(ans)
        return ans
