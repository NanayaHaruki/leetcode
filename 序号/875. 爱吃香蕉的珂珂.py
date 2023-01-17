class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l,r=0,max(piles)+1
        while l+1<r:
            m=(l+r)//2
            hours=0
            for x in piles:
                # 1小时吃（0,x] (x,2x]需要2小时
                hours += (x-1)//m+1
                if hours>h:break
            if hours<=h:
                r=m
            else:
                l=m
        return r