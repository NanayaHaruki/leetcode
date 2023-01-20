class Solution:
    def findingUsersActiveMinutes(self, logs: List[List[int]], k: int) -> List[int]:
        ans=[0]*k
        d={}
        for id,time in logs:
            if id in d:
                d[id].add(time)
            else:
                d[id]={time}
        for id in d:
            ops=len(d[id])
            ans[ops-1]+=1
        return ans