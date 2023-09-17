class Solution:
    def rob(self, nums: List[int]) -> int:
        def dp(l,r):
            a=b=0
            for i in range(l,r+1):
                c=max(b,a+nums[i]) # 上一家的最大值，这次不拿;上上家+这次拿
                a,b=b,c
            return b 
        n=len(nums)
        if n==1:return nums[0]
        return max(nums[0]+dp(2,n-2),dp(1,n-1))# 拿了第1家，1和n-1不能拿;不拿第1家，1和n-1可以拿
        