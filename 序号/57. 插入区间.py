class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        ans=[]
        start,end=newInterval
        if not intervals:
            return [newInterval]
        if start < intervals[0][0]:
            ans.append([start,end])
            newInterval=None
     
        def handle(l,r):
            if l<=ans[-1][1]:
                if r>ans[-1][1]:
                    ans[-1][1]=r
            else:
                ans.append([l,r])
        for l,r in intervals:
            if not ans:
                ans.append([l,r])
                continue
            if not newInterval:
                handle(l,r)
                continue

            if start<l:
                handle(start,end)
                newInterval=None          
            handle(l,r)
        if newInterval:
            handle(start,end)          
        return ans