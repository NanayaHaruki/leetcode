class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        n =len(arr)
        if k>=n-1:
            return max(arr)
        q=deque(arr)
        winCnt = 0
        winNum = inf
        while True:
            a,b = q.popleft(),q.popleft()
            if a>b:
                q.appendleft(a)
                q.append(b)
                if winNum==a:
                    winCnt+=1
                else:
                    winCnt=1
                    winNum=a
            else:
                q.appendleft(b)
                q.append(a)
                if winNum==b:
                    winCnt+=1
                else:
                    winCnt=1
                    winNum=b
            if winCnt==k:return winNum