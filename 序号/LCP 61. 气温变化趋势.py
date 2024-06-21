class Solution:
    def temperatureTrend(self, temperatureA: List[int], temperatureB: List[int]) -> int:
        curLen =mx= 0
        n = len(temperatureA)
        for i in range(1,n):
            a,b=temperatureA[i],temperatureB[i]
            if (a>temperatureA[i-1] and b>temperatureB[i-1]):
                curLen+=1
            elif a==temperatureA[i-1] and b==temperatureB[i-1]:
                curLen+=1
            elif a<temperatureA[i-1] and b<temperatureB[i-1]:
                curLen+=1
            else:
                mx=max(mx,curLen)
                curLen=0
        return max(mx,curLen)