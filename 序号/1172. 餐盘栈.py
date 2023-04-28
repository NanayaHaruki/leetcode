from sortedcontainers import SortedSet
class DinnerPlates:

    def __init__(self, capacity: int):
        self.tl=[]
        self.cap=capacity
        self.notFullIndex=SortedSet()


    def push(self, val: int) -> None:
        if self.notFullIndex:
            idx = self.notFullIndex[0]
            self.tl[idx].append(val)
            if len(self.tl[idx])==self.cap:
                self.notFullIndex.remove(idx)
        else:
            if self.tl:
                if len(self.tl[-1])==self.cap:
                    self.tl.append([val])
                else:
                    self.tl[-1].append(val)
            else:
                self.tl.append([val])
        
            
    def pop(self) -> int:
      while self.tl and not self.tl[-1]:
          self.tl.pop()
          if len(self.tl) in self.notFullIndex:
              self.notFullIndex.remove(len(self.tl))
      if self.tl :
          ret= self.tl[-1].pop()
          if not self.tl[-1]:
              self.tl.pop()
              if len(self.tl) in self.notFullIndex:
                self.notFullIndex.remove(len(self.tl))
          return ret
      else:
          return -1

    def popAtStack(self, index: int) -> int:
        if index>=len(self.tl) or not self.tl[index]:
            return -1      
        ret =  self.tl[index].pop()
        if index==len(self.tl)-1 :
            if not self.tl[index]:
                self.tl.pop()
                if index in self.notFullIndex:
                    self.notFullIndex.remove(index)
        else:
            self.notFullIndex.add(index)
        return ret