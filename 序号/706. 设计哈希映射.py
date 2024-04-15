class Node:
    next = None
    def __init__(self,k,v):
        self.k = k
        self.v = v
MX=10007
def hash(x:int):
    return x%MX
class MyHashMap:

    def __init__(self):
        self.entries = [None]*MX

    def put(self, key: int, value: int) -> None:
        h = hash(key)
        p = self.entries[h]
        if not p:
            self.entries[h]=Node(key,value)
        else:
            while p:
                if p.k ==key:
                    p.v = value
                    return
                if p.next is None:
                    p.next = Node(key,value)
                    return
                p=p.next

    def get(self, key: int) -> int:
        h = hash(key)
        p = self.entries[h]
        if not p:return -1
        while p:
            if p.k==key:
                return p.v
            p=p.next
        return -1

    def remove(self, key: int) -> None:
        h = hash(key)
        p = self.entries[h]
        if not p:return
        if p.k == key:
            self.entries[h]=p.next
            return 
        while p.next:
            if p.next.k == key:
                p.next=p.next.next
                return
            p=p.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)