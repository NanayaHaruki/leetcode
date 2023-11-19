class Solution:
    def maxSumOfThreeSubarrays(self, nums: List[int], k: int) -> List[int]:
        '''找3个长度为k的不重叠的数组 ,让他们和最大'''
        sm1=sm2=sm3=0
        mxIdx1,mxIdx12,mxIdx123=0,[0,k],[0,k,2*k]
        for i in range(k):
            sm1+=nums[i]
            sm2+=nums[k+i]
            sm3+=nums[2*k+i]
        mx1,mx12,mx123=sm1,sm1+sm2,sm1+sm2+sm3
        for i in range(3*k,len(nums)):
            sm1=sm1+nums[i-2*k]-nums[i-3*k]
            sm2=sm2+nums[i-k]-nums[i-2*k]
            sm3=sm3+nums[i]-nums[i-k]
            if sm1>mx1:
                mx1,mxIdx1=sm1,i-3*k+1
            if mx1+sm2>mx12:
                mx12=mx1+sm2
                mxIdx12[0]=mxIdx1
                mxIdx12[1]=i-2*k+1
            if mx12+sm3>mx123:
                mx123=mx12+sm3
                mxIdx123[0]=mxIdx12[0]
                mxIdx123[1]=mxIdx12[1]
                mxIdx123[2]=i-k+1
        return mxIdx123