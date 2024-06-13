class Solution:
    def findMaximumElegance(self, items: List[List[int]], k: int) -> int:
        items.sort(reverse=True)
        sum_profit = 0 # 总利润
        categories = set() # 有几类
        cache = [] # 重复的类的利润，第1个永远不会插入，因为利润是最大的要留住
        for i in range(k):
            sum_profit+=items[i][0]
            if items[i][1] in categories:
                cache.append(items[i][0])
            else:
                categories.add(items[i][1])
        ans = sum_profit + len(categories)**2
        for i in range(k,len(items)):
            if cache and items[i][1] not in categories:
                categories.add(items[i][1])
                sum_profit = sum_profit - cache.pop() + items[i][0]
                ans = max(ans,sum_profit+len(categories)**2)
        return ans