class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        n=len(nums)
        nums.sort()
        ans=nums[0]+nums[1]+nums[2]
        for i in range(n-2):
            j,k=i+1,n-1

            while j<k:
                s=nums[i]+nums[j]+nums[k]
                if abs(s-target)<abs(ans-target):
                    ans=s
                if s==target:
                    return target
                if s<target:
                    j+=1
                else:
                    k-=1
        return ans