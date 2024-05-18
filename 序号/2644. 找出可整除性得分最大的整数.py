class Solution:
    def maxDivScore(self, nums: List[int], divisors: List[int]) -> int:
        mxCnt = 0
        mxIdx = 0
        for i,d in enumerate(divisors):
            cnt = 0
            for x in nums:
                if x%d==0:
                    cnt+=1
            if cnt>mxCnt or (cnt==mxCnt and d<divisors[mxIdx]):
                mxCnt=cnt
                mxIdx=i
        return divisors[mxIdx]
