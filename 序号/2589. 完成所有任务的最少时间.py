class Solution:
    def findMinimumTime(self, tasks: List[List[int]]) -> int:
        # 每个任务尽量往后排，下个任务会用到上一个任务的后缀
        # [1,3] [2,5] 公用[2,3]
        tasks.sort(key=lambda x:x[1])
        run = [0]*(tasks[-1][1]+1)
        time = 0
        for l,r,d in tasks:
            # 这个任务要在[l,r]运行d个时间,统计之前的任务在这个区间内已经运行的时间，新任务扣掉
            for i in range(l,r+1):
                if run[i]==1:
                    d-=1
            if d<=0:continue
            # 还要运行，从后开始运行
            for i in range(r,l-1,-1):
                if run[i]:continue
                run[i]=1
                time+=1
                d-=1
                if d==0:break
        return time

            
