class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        # 最大最小 一眼二分
        # nums切割连续子数组，根据mid切，看能分成多少组，超过k就不行，让mid大点
     
        def split(mxSum):
            ''' 每组和最大mxSum，可以切成多少组 '''
            cnt=sm=0
            for x in nums:
                if x > mxSum:
                    return False
                if sm+x>mxSum:
                    cnt+=1
                    sm=x
                else:
                    sm+=x
            return cnt+1<=k
        sm=sum(nums)
        n=len(nums)
        l,r=-1,sm+1
        while l+1 < r:
            mid = (l+r)//2
            if split(mid):
                r=mid
            else: # 满足条件 
                l=mid
        return r