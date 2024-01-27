class Solution:
    def maxNumberOfAlloys(self, n: int, k: int, budget: int, composition: List[List[int]], stock: List[int], cost: List[int]) -> int:
        # n种金属 k种机器 资金限制budget
        l,r=-1,budget+max(stock)+1 # 双开区间，0可以取一个都做不了，左区间为-1;只要1种金属，金属价格为1，能做budget个
        while l+1<r:
            mid = (l+r)//2
            isFind = False
            for metals in composition:
                curCost = 0
                for i,x in enumerate(metals):
                    curCost+=max(0,(x*mid-stock[i])*cost[i])
                    if curCost>budget: # 超出预算，不要检查这个机器的其他材料了
                        break
                if curCost>budget: # 检查其他机器能不能满足制造mid份
                    continue
                isFind=True
                break
            if isFind:l=mid
            else: r=mid
        return l