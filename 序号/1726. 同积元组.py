class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        # 统计所有积的数量
        cnt = Counter()
        for i in range(len(nums)):
            for j in range(i+1,len(nums)):
                x=nums[i]*nums[j]
                cnt[x]+=1
        ans=0
        for _,c in cnt.items():
            if c>1:
                ans+=c*(c-1)*4  # n*(n-1)//2*8
        return ans