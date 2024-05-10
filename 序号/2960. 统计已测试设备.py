class Solution:
    def countTestedDevices(self, batteryPercentages: List[int]) -> int:
        ans=0
        for x in batteryPercentages:
            if x-ans>0:
                ans+=1
        return ans