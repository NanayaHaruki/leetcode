class Solution:
    def minOperationsMaxProfit(self, customers: List[int], boardingCost: int, runningCost: int) -> int:
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