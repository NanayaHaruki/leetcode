class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        for idx,interval in enumerate(intervals):
            interval.append(idx)
        intervals.sort()
        n=len(intervals)
        ans=[-1]*n
        for _,end,idx in intervals:
            i = bisect.bisect_left(intervals,[end])
            if i<n:
                ans[idx]=intervals[i][2]
        return ans