import sortedcontainers
class StockPrice:

    def __init__(self):
        self.sl=sortedcontainers.SortedList()
        self.d=sortedcontainers.SortedDict()

    def update(self, timestamp: int, price: int) -> None:
        if timestamp in self.d:
            oldValue=self.d[timestamp]
            self.sl.remove(oldValue)
        self.d[timestamp]=price
        self.sl.add(price)

    def current(self) -> int:
        return self.d.peekitem()[1]


    def maximum(self) -> int:
        return self.sl[-1]

    def minimum(self) -> int:
        return self.sl[0]