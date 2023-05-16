class Solution:
    def minDifficulty(self, jobDifficulty: List[int], d: int) -> int:
        n=len(jobDifficulty)
        if n<d:
            return -1
        # 通过统计难度出现位置，再2次二分 可以确定区间最大值
        @cache
        def dfs(endIndex,parts):
            ''' 在parts天内完成 [0,endIndex]的工作'''
            if parts==1:
                return max(jobDifficulty[:endIndex+1])
            lastMax,totalMax=0,math.inf
            for i in range(endIndex,parts-2,-1): # 2天，最后任务能取到1，边界得到0，所以parts-2
                lastMax=max(lastMax,jobDifficulty[i])         
                total = dfs(i-1,parts-1)            
                totalMax=min(totalMax,total+lastMax)
            return totalMax
        return dfs(n-1,d)