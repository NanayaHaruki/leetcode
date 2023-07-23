class Solution:
    def trap(self, height: List[int]) -> int:
        # 每个横坐标能接多少雨水，取决于左右最高点的较小值
        # 先求出两遍最大最小值
        n = len(height)
        ml = [0]*n
        mr=[0]*n # mr[i]表示i右边最大的数
        ans=0
        for i in range(n-2,-1,-1):
            mr[i]=max(mr[i+1],height[i+1]) # max( 比i+1更大的，i+1自己)
        for i in range(1,n-1):
            ml[i]=max(ml[i-1],height[i-1])
            h = min(ml[i],mr[i])
            if h>height[i]:
                ans+=(h-height[i])
        return ans