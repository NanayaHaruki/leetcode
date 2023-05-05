class Solution:
    def hardestWorker(self, n: int, logs: List[List[int]]) -> int:
        preId,preTime,mxDiff,ansId=-1,0,0,0
        n=len(logs)
        for i in range(n):
            curId,curTime=logs[i][0],logs[i][1]
            diff=curTime-preTime
            if diff > mxDiff:
                mxDiff=diff
                ansId=curId
            elif diff==mxDiff:
                if curId<ansId:
                    ansId=curId
            preId,preTime=curId,curTime
        return ansId
 

