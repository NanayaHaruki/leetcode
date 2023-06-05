class Solution:
    def applyOperations(self, nums: List[int]) -> List[int]:
        n=len(nums)
        ans=[0]*n
        i=j=0
        while i<n-1:
            a,b=nums[i],nums[i+1]
            if a==0:
                i+=1
                continue
            if a==b:
                ans[j]=a*2
                j+=1
                nums[i+1]=0
                i+=2
            else:
                ans[j]=a
                j+=1
                i+=1
        ans[j]=nums[-1] # 只检查到n-2 ,补上n-1
        return ans
