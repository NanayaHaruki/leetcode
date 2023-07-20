class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        n=len(nums)
        # 求最大子数组和 因为能首尾相连，同时求最小和，数组整体和-最小和的部分就是最大和了
        preMn,preMx,ansMn,ansMx=0,0,math.inf,-math.inf
        for x in nums:
            preMn=min(x,preMn+x)
            preMx=max(x,preMx+x)
            ansMn=min(ansMn,preMn)
            ansMx=max(ansMx,preMx)
        sm=sum(nums)
        if sm==preMn:
            return ansMx
        else:
            return max(ansMx,sm-preMn)