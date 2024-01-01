class Solution:
    def minOperationsMaxProfit(self, customers: List[int], boardingCost: int, runningCost: int) -> int:
        # 贪心
        i=0
        ans=-1
        w=customers[i]
        mxProfit=p=w*boardingCost
        n=len(customers)
        while w or i<n: # 还有人排队 或 暂时没人，但后面的时间点还会来人
            if w>=4:
                p=p+4*boardingCost-runningCost
                w-=4
            else:
                p=p+w*boardingCost-runningCost
                w=0
            i+=1
            if p>mxProfit:
                mxProfit=p
                ans=i
            if i<n:
                w+=customers[i]
        return ans
        mx = 0 # 最大利润
        ans=-1
        cnt = 0 # 第几次转
        customerQueue = customers[0] # 排队的顾客数
        profit = 0 # 利润
        while  cnt < len(customers) or customerQueue:
            cnt+=1
            if customerQueue>=4:
                profit=profit+4*boardingCost-runningCost
                customerQueue-=4
            else:
                profit=profit+customerQueue*boardingCost-runningCost
                customerQueue=0
            if profit>mx:
                ans=cnt
                mx=profit
            if cnt < len(customers):
                customerQueue+=customers[cnt]
        return ans