class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        mv=mh=0
        pre=0
        verticalCuts.sort()
        horizontalCuts.sort()
        for x in verticalCuts:
            mv=max(mv,x-pre)
            pre=x
        mv=max(mv,w-pre)
        pre=0
        for x in horizontalCuts:
            mh=max(mh,x-pre)
            pre=x
        mh=max(mh,h-pre)
        return mv*mh%1000000007