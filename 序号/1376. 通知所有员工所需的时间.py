class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        d={}
        for i,x in enumerate(manager):
            if x in d:
                d[x].append(i)
            else:
                d[x]=[i]
        mxTime=0
        def dfs(p,t):
            
            if p not in d:
                nonlocal mxTime
                mxTime=max(mxTime,t)
                return
            t+=informTime[p]
            for i in d[p]:
                dfs(i,t)
        dfs(headID,0)
        return mxTime