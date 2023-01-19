class Solution:
    def getNumberOfBacklogOrders(self, orders: List[List[int]]) -> int:
        '''orders[i] = [pricei, amounti, orderTypei] 0buy 1sell'''
        # 对销售订单，要找采购价格最高的；对采购订单，要找销售订单最低的；搞2个优先队列
        sells ,buys= [],[]
        ans,mod=0,int(1e9+7)
        for price,amount,orderType in orders:
            if orderType: #销售订单
                if not buys or -buys[0][0]<price: #没有可匹配的采购订单
                    heapq.heappush(sells,[price,amount])
                else : #有匹配的，比对订单数量
                    while amount and buys and -buys[0][0]>=price:
                        if buys[0][1]>amount: # 采购的更多
                            buys[0][1]-=amount
                            amount=0
                        elif buys[0][1]<amount:
                            amount-=buys[0][1]
                            heapq.heappop(buys)
                        else :
                            heapq.heappop(buys)
                            amount=0
                    if amount:
                        heapq.heappush(sells,[price,amount])
            else :
                if not sells or sells[0][0]>price:
                    heapq.heappush(buys,[-price,amount])
                else:
                    while amount and sells and sells[0][0]<=price:
                        if sells[0][1]>amount:
                            sells[0][1]-=amount
                            amount=0
                        elif sells[0][1]<amount:
                            amount -= sells[0][1]                           
                            heapq.heappop(sells)
                        else:
                            heapq.heappop(sells)
                            amount=0
                    if amount:
                        heapq.heappush(buys,[-price,amount])
        for _,amount in sells:
            ans=(ans+amount)%mod
        for _,amount in buys:
            ans=(ans+amount)%mod
        return ans