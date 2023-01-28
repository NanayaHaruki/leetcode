class Solution:
    def waysToMakeFair(self, nums: List[int]) -> int:
        n=len(nums)
        if n==1:return 1
        pso=[0]*n
        pse=[0]*n
        pse[0]=nums[0]
        pso[1]=nums[1]
        for i in range(n):
            if i&1:
                pso[i]=pso[i-1]+nums[i]
                pse[i]=pse[i-1]
            else:
                pse[i]=pse[i-1]+nums[i]
                pso[i]=pso[i-1]
        cnt=0
        for i in range(n):
            odd,even=pso[i],pse[i]
            if i&1:
                odd-=nums[i]
            else:
                even-=nums[i]
            # 删除i索引的值后，i后面的奇偶互换
            even+=pso[-1]-pso[i]
            odd+=pse[-1]-pse[i]
            if even==odd:
                cnt+=1
        return cnt