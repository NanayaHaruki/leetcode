class Solution:
    def getMaximumConsecutive(self, coins: List[int]) -> int:
        # 如果已经满足了[0,X]，题目要求是连续的，则现在多了个y，可以多出[y,x+y]的区间
        # 每次选择最小的y，让[0,x][y,x+y]产生交叉，则可以达到的范围变成[0,x+y]
        coins.sort()
        x=0
        for y in coins:
            if y<=x+1:
                x+=y
            else :
                break
        return x+1