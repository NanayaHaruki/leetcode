class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        # queries[i]在intervals哪个区间内，ans[i]为最小的区间长度
        # 离线查询，将queries排序，先查小的，就可以一遍查完intervals，不用n^2查了
        queries=sorted((x,i) for i,x in enumerate(queries))
        intervals.sort()
        m,n=len(intervals),len(queries)
        ans=[-1]*n
        j=0
        q=[]
        for x,i in queries:
            # 将左边界小于x的入队，队列根据区间长度排序。再将右边界小于x的不满足条件的出队，堆顶的就是答案
            while j<m and intervals[j][0]<=x:
                heapq.heappush(q,(intervals[j][1]-intervals[j][0]+1,intervals[j][1]))
                j+=1
            while q and q[0][1]<x:
                heapq.heappop(q)
            if q:
                ans[i]=q[0][0]
        return ans