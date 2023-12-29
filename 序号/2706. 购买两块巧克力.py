class Solution:
    def buyChoco(self, prices: List[int], money: int) -> int:
        # 返回剩下的最多，就是找和不超过money的价格最低的2个
        a,b=prices[:2]
        if a>b:a,b=b,a
        n=len(prices)
        for i in range(2,n):
            x=prices[i]
            if x<a:
                a,b=x,a
            elif a<=x<b:
                b=x
        if a+b<=money:
            return money-a-b
        return money

        # ans=money
        # n=len(prices)
        # mxRemain=-1
        # for i in range(n-1):
        #     for j in range(i+1,n):
        #         remain = money - prices[i] - prices[j]
        #         if remain>=0:
        #             mxRemain=max(remain,mxRemain)
        # return money if mxRemain==-1 else mxRemain