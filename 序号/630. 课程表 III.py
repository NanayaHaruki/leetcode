class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        # 尽量多的上课，按结束时间排序，先上早结束的;
        # 如果已经上的课有比当前新课久的，将久的老课换成新课，这样上课数量不变，但消耗时间少了，有利后面增加课
 
        courses.sort(key=lambda x:x[1])
        q=[]
        start=0
        for duration,end in courses:
            if start+duration<=end: # 能上就生
                start+=duration
                heapq.heappush(q,-duration)
            else: # 不能上，看能否换一下
                if q:
                    preLongestDuration=-q[0]
                    if duration<preLongestDuration:
                        heapq.heapreplace(q,-duration)
                        start-=(preLongestDuration-duration)
        return len(q)