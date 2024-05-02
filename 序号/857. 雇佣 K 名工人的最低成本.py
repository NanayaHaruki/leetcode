class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        # 按工作质量发工资，且必须满足最低要求
        # 让某个人以最低工资发放，其他人
        # q=10，5   w = 100，20   0号发100，1号发50， 0号资质比是10，1号是4，选0作为基准，1号肯定能满足要求
        # 按工资/质量的比值排序，选前k个人求总工资。 往后遍历检查，后面的比值虽然会升高，但质量降低也有可能出现总值更低的答案
        p = sorted(zip(quality,wage),key=lambda x:x[1]/x[0])
        hq = [-q for q,_ in p[:k]] # 质量的大顶堆
        heapify(hq)
        sm = -sum(hq)
        ans = sm*p[k-1][1]/p[k-1][0]
        for q,w in p[k:]:
            if q < -hq[0]:
                topQ = -heappop(hq)
                heappush(hq,-q)
                sm = sm-topQ+q
                ans=min(ans,sm*w/q)
        return ans