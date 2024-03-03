class MyStack:

    def __init__(self):
        self.q1=deque()
        self.q2=deque()

    def push(self, x: int) -> None:
        if self.q2:
            self.q2.append(x)
        else:
            self.q1.append(x)

    def pop(self) -> int:
        if self.q1:
            while len(self.q1)>1:
                x = self.q1.popleft()
                self.q2.append(x)
            return self.q1.popleft()
        else:
            while len(self.q2)>1:
                x = self.q2.popleft()
                self.q1.append(x)
            return self.q2.popleft()

    def top(self) -> int:
        if self.q1:
            return self.q1[-1]
        else:
            return self.q2[-1]

    def empty(self) -> bool:
        return  len(self.q1) + len(self.q2)  == 0
