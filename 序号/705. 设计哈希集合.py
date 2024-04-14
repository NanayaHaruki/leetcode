class Node:
    def __init__(self,v:int,next: Optional['Node'] =None):
        self.v =v 
        self.next = next
def hash(x:int): 
    ''' x最大10^6,小于2^4^6,二进制最多24位 '''
    return x % 10007
class MyHashSet:


    
    def __init__(self):
        self.arr = [None]*10007
        

    def add(self, key: int) -> None:
        h = hash(key)
        # print(h,len(self.arr))
        if self.arr[h] is None:
            self.arr[h]=Node(key)
            return
        p = self.arr[h]
        while p:
            if p.v == key:
                return
            if p.next:
                p=p.next
            else:
                p.next = Node(key)
                return

    def remove(self, key: int) -> None:
        h = hash(key)
        if self.arr[h] is None:return
        p = self.arr[h]
        if p.v == key:
            self.arr[h]=p.next
            return
        while p.next:
            if p.next.v == key:
                p.next = p.next.next
                return
            else:
                p=p.next

    def contains(self, key: int) -> bool:
        h = hash(key)
        if self.arr[h] is None:
            return False
        p = self.arr[h]
        while p:
            if p.v==key:
                return True
            p=p.next
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)