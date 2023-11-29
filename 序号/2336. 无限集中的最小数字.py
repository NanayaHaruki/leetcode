import sortedcontainers
class SmallestInfiniteSet:
    # 逆向思维
    def __init__(self):
        self.mn=1
        self.st=sortedcontainers.SortedSet()

    def popSmallest(self) -> int:
        if not self.st:
            self.mn+=1
            return self.mn-1
        return self.st.pop(0)

    def addBack(self, num: int) -> None:
        if num <self.mn:
            self.st.add(num)

    # 根据数据范围正向思维 
    # def __init__(self):
    #     st=sortedcontainers.SortedSet([x for x in range(1,1010)])
    #     self.st=st

    # def popSmallest(self) -> int:
    #     return self.st.pop(0)

    # def addBack(self, num: int) -> None:
    #     if num in self.st:return
    #     self.st.add(num)


# Your SmallestInfiniteSet object will be instantiated and called as such:
# obj = SmallestInfiniteSet()
# param_1 = obj.popSmallest()
# obj.addBack(num)