class Solution:
    def jobScheduling(self, startTime: List[int], endTime: List[int], profit: List[int]) -> int:
        # 按结束时间排序得到jobs，f[i]为完成前i个工作获得的最大利益
        # f[i]=max(f[i-1],f[j]+jobs[i][收益])  
        # f[i]必然递增，所以要找最大的j，使前j个工作的完成时间早于第i个工作的开始时间
        jobs = sorted(zip(endTime,startTime,profit))
        n=len(startTime)
        f = [0]*n
        f[0]=jobs[0][2]
        for i in range(1,n):
            et,st,p = jobs[i]
            # 找结束时间小于开始时间的
            j = bisect.bisect_right(jobs,(st,inf,inf),0,i)
            a=f[i-1]
            b=p
            if j>0:b+=f[j-1]
            f[i]=max(a,b)
        return f[-1]