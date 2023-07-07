class Solution:
    def findCrossingTime(self, n: int, k: int, time: List[List[int]]) -> int:
        # n个箱子 k个工人
        # 桥有人 等
        # 右边先行，右边没人才能左边
        # 左右都是效率低的先
        waitL, waitR,putL,putR = [], [],[],[] #左右正在等待过桥的 和正在仓库干活的
        for i in range(k):
            heapq.heappush(waitL, (-time[i][0]-time[i][2],-i))

        ans=0
        while n or waitR or putR:
            # 处理正在仓库的人
            while putR and putR[0][0]<=ans:
                idx=heapq.heappop(putR)[1]
                heapq.heappush(waitR,(-time[idx][0]-time[idx][2],-idx))
            while putL and putL[0][0]<=ans:
                idx=heapq.heappop(putL)[1]
                heapq.heappush(waitL,(-time[idx][0]-time[idx][2],-idx))
            
            if waitR: # 右边先行
                idx = -heapq.heappop(waitR)[1]
                ans+=time[idx][2]
                heapq.heappush(putL,(ans+time[idx][3],idx))
            elif n>0 and waitL: # 还要搬 且左边有人, 左边过桥
                idx=-heapq.heappop(waitL)[1]
                ans+=time[idx][0]
                heapq.heappush(putR,(ans+time[idx][1],idx))
                n-=1
            else: # 没人要过桥，等仓库干活的人回来
                t = math.inf
                if putL:
                    t=putL[0][0]
                if putR:
                    t=min(t,putR[0][0])
                if t!=math.inf:
                    ans=max(ans,t)
        return ans