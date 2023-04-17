class Solution:
    def countDaysTogether(self, arriveAlice: str, leaveAlice: str, arriveBob: str, leaveBob: str) -> int:
        daysOfMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        startMonthA,startDayA,endMonthA,endDayA=int(arriveAlice[:2]),int(arriveAlice[3:]),int(leaveAlice[:2]),int(leaveAlice[3:])
        startMonthB,startDayB,endMonthB,endDayB=int(arriveBob[:2]),int(arriveBob[3:]),int(leaveBob[:2]),int(leaveBob[3:])
        if startMonthA>endMonthB or (startMonthA==endMonthB and startDayA>endDayB) or startMonthB>endMonthA or (startMonthB==endMonthA and startDayB>endDayA):
            return 0
        startMonth,startDay,endMonth,endDay = startMonthA,startDayA,endMonthA,endDayA
        if startMonthB>startMonthA or (startMonthB==startMonthA and startDayB>startDayA):
            startMonth,startDay=startMonthB,startDayB
        if endMonthB<endMonthA or (endMonthB==endMonthA and endDayB<endDayA):
            endMonth,endDay=endMonthB,endDayB
        if startMonth==endMonth:
            return endDay-startDay+1
        ans=0
        for i in range(startMonth,endMonth+1):
            if i == startMonth:
                ans+=daysOfMonth[i-1]-startDay+1
            elif i==endMonth:
                ans+=endDay
            else:
                ans+=daysOfMonth[i-1]
        return ans