class Solution:
    def minSpeedOnTime(self, dist: List[int], hour: float) -> int:
        if hour <= len(dist)-1:
            return -1
        l,r=0,int(1e7+1)
        while l+1<r:
            m=(l+r)//2
            sum=0
            for i in range(len(dist)-1):# 最后一班车不用向上取整
                sum+=ceil(dist[i]/m)
            sum+=dist[-1]/m
            if sum<=hour:
                r=m
            else:
                l=m
        return r