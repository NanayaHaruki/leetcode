class StockSpanner:

    def __init__(self):
        self.q=deque()
        self.idx=-1
        self.q.append((-1,math.inf))

    def next(self, price: int) -> int:
        self.idx+=1
        while self.q[-1][1]<=price:
            self.q.pop()
        ans=self.idx-self.q[-1][0]
        self.q.append((self.idx,price))
        return ans


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)