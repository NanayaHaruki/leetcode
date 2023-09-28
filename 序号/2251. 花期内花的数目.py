class Solution:
    def fullBloomFlowers(self, flowers: List[List[int]], people: List[int]) -> List[int]:
        # flowers[i] 每朵花开放时间  people 人来的时间  返回 人到的时候花的开放数目
        # 离散 差分 前缀和
        times={50001}
        for l,r in flowers:
            times.add(l)
            times.add(r+1)
        sortedTime = sorted(times)
        timeDict={}
        for i,time in enumerate(sortedTime):
            timeDict[time]=i
        diffList=[0]*len(sortedTime)
        for l,r in flowers:
            diffList[timeDict[l]]+=1
            diffList[timeDict[r+1]]-=1
        for i in range(1,len(diffList)):
            diffList[i]+=diffList[i-1]
        ans=[0]*len(people)
        for i,p in enumerate(people):
            l,r=-1,len(diffList)
            while l+1<r:
                mid=(l+r)//2
                acturlTime=sortedTime[mid]
                if acturlTime<=p:
                    l=mid
                elif acturlTime>p:
                    r=mid
            ans[i]=diffList[l]
        return ans