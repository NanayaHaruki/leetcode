class Solution:
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        return not (event1[0]>event2[1] or event1[1]<event2[0])
        # start1,end1=int(event1[0][:2])*60+int(event1[0][3:]),int(event1[1][:2])*60+int(event1[1][3:])
        # start2,end2=int(event2[0][:2])*60+int(event2[0][3:]),int(event2[1][:2])*60+int(event2[1][3:])
        # return False if start2>end1 or end2<start1 else True
