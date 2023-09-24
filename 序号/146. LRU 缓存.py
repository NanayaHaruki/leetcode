class Node:
    def __init__(self,pre,next,key,val) -> None:
        self.pre=pre
        self.next=next
        self.key=key
        self.val=val
class LRUCache:
    def __init__(self, capacity: int):
        # 通过key查询value，value存在双向链表中的一个node里
        # 存往表头插入，超过容量删掉表尾
        # 取，根据key拿到node，将node前后链接，将node插到表头
        self.cap=capacity
        self.sz=0
        self.d={}
        self.head=self.tail=None

    def pr(self):
        h,t=self.head,self.tail
        p=''
        while h:
            p+=f'{h.key},'
            h=h.next
        pp=''
        while t:
            pp+=f'{t.key},'
            t=t.pre
        return f'{p} {pp}'

    def access(self,key):
        # 存和取 都会将包含key的node移动到head位置
        node=self.d[key] if key in self.d else None
        if node:
            if node.pre:
                node.pre.next=node.next
                if node.next:
                    node.next.pre=node.pre
                else:
                    self.tail=node.pre
                node.pre=None
                node.next=self.head
                self.head.pre=node
                self.head=node
            return node
        else:
            return None
    
    def get(self, key: int) -> int:
        node=self.access(key)
        # print(f'get{key}',self.pr(),[f'{x}:{y.val}' for x,y in self.d.items()])     
        return node.val if node else -1

    def put(self, key: int, value: int) -> None:
        node=self.access(key)
        if node is None:
            node = Node(None,self.head,key,value)
            self.d[key]=node
            self.sz+=1
            node.next=self.head
            if self.head:
                self.head.pre=node
            self.head=node
            if self.sz==1:
                self.head=self.tail=node
        else:
            node.val=value
        if self.sz>self.cap:
            if self.tail.key in self.d:
                self.d.pop(self.tail.key)   
            if self.tail.pre:
                self.tail.pre.next=None
            self.tail=self.tail.pre
            self.sz-=1
        # print(f'put{key}',self.pr(),[f'{x}:{y.val}' for x,y in self.d.items()])