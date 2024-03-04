class MyQueue:

    def __init__(self):
        self.s1=[]
        self.s2=[]

    def push(self, x: int) -> None:
        while self.s2:
            self.s1.append(self.s2.pop())
        self.s1.append(x)

    def pop(self) -> int:
        if self.s2:
            return self.s2.pop()
        while len(self.s1)>1:
            self.s2.append(self.s1.pop())
        return self.s1.pop()
        
    def peek(self) -> int:
        if self.s2:
            return self.s2[-1]
        return self.s1[0]

    def empty(self) -> bool:
        return len(self.s1)+len(self.s2)==0



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()