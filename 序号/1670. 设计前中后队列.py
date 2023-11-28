class FrontMiddleBackQueue:

    def __init__(self):
        self.q1=deque()
        self.q2=deque()

    def pushFront(self, val: int) -> None:
        self.q1.appendleft(val)
        if len(self.q1)>len(self.q2)+1:
            self.q2.appendleft(self.q1.pop())

    def pushMiddle(self, val: int) -> None:
        if len(self.q1)==len(self.q2):
            self.q1.append(val)
        else:
            self.q2.appendleft(self.q1.pop())
            self.q1.append(val)

    def pushBack(self, val: int) -> None:
        self.q2.append(val)
        if(len(self.q2)>len(self.q1)):
            self.q1.append(self.q2.popleft())

    def popFront(self) -> int:
        if not self.q1:return -1
        ans=self.q1.popleft()
        if len(self.q1)<len(self.q2):
            self.q1.append(self.q2.popleft())
        return ans

    def popMiddle(self) -> int:
        if not self.q1: return -1
        ans=self.q1.pop()
        if len(self.q1)<len(self.q2):
            self.q1.append(self.q2.popleft())
        return ans

    def popBack(self) -> int:
        if self.q2 :
            ans=self.q2.pop()
            if len(self.q1)-len(self.q2)>1:
                self.q2.appendleft(self.q1.pop())
            return ans
        else:
            if not self.q1:return -1
            return self.q1.pop()