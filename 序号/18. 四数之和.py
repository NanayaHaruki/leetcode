class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        n=len(nums)
        ans=[]
        i=0
        while i<n-3:
            if i and nums[i]==nums[i-1]:
                i+=1
                continue
            if nums[i]+nums[-1]+nums[-2]+nums[-3]<target:
                i+=1
                continue
            if nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target:
                break
            j=i+1
            while j<n-2:
                if j!=i+1 and nums[j]==nums[j-1]:
                    j+=1
                    continue
                if nums[i]+nums[j]+nums[j+1]+nums[j+2]>target:
                    break
                if nums[i]+nums[j]+nums[-1]+nums[-2]<target:
                    j+=1
                    continue
                l,r=j+1,n-1
                while l<r:
                    s=nums[i]+nums[j]+nums[l]+nums[r]
                    if s<target:
                        l+=1
                    elif s>target:
                        r-=1
                    else:
                        ans.append([nums[i],nums[j],nums[l],nums[r]])
                        l+=1
                        while l<r and nums[l]==nums[l-1]:
                            l+=1
                        r-=1
                        while l<r and nums[r]==nums[r+1]:
                            r-=1
                j+=1
            i+=1
       
        return ans