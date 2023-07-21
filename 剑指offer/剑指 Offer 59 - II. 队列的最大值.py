class MaxQueue:

    def __init__(self):
        self.q = deque()
        self.dq=deque()


    def max_value(self) -> int:
        return -1 if not self.dq else self.dq[0]

    def push_back(self, value: int) -> None:
        self.q.append(value)
        while self.dq and self.dq[-1]<value:
            self.dq.pop()
        self.dq.append(value)


    def pop_front(self) -> int:
        q,dq=self.q,self.dq
        if not q:return -1
        if q[0]==dq[0]:
            dq.popleft()
        return q.popleft()
