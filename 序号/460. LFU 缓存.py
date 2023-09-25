class Node:
    __slot__='k','v','f','pre','next'

    def __init__(self,k,v,f,pre,next) -> None:
        self.k=k
        self.v=v
        self.f=f
        self.pre=pre
        self.next=next

    def __str__(self) -> str:
        c,d=self,''
        while c:
            d+=f'{c.k}'
            c=c.next
        return d


class LFUCache:

    def pr(self,f):
        c=self.dummys[f].next
        d=''
        while c!=self.dummys[f]:
            d+=f'{c.k}'
            c=c.next
        return d
    
    def __init__(self, capacity: int):
        self.dummys=[None] # dummys[1]表示频率为1的节点
        d1=Node(0,0,1,None,None)
        d1.next=d1
        d1.pre=d1
        self.dummys.append(d1)

        self.cap=capacity
        self.d={} # 根据key 查找node，变更node所在队列，更新dummys
        self.sz=0

    def access(self,k:int):
        node = self.d[k] if k in self.d else None 
        if not node:return None
        
        node.pre.next=node.next # 从所在链表移动到更高频次的链表中
        node.next.pre=node.pre
        node.f+=1
        if node.f==len(self.dummys):
            new_f_dummy=Node(0,0,node.f,node,node)
            node.pre=new_f_dummy
            node.next=new_f_dummy
            self.dummys.append(new_f_dummy)
        else:
            dummy=self.dummys[node.f]
            last_node = dummy.pre
            last_node.next=node
            node.pre=last_node
            node.next=dummy
            dummy.pre=node
        return node


    def get(self, key: int) -> int:
        node = self.access(key)
        return node.v if node else -1

    def put(self, key: int, value: int) -> None:
        node = self.access(key)
        if node:
            node.v=value
            self.d[key]=node
        else:
            if self.sz==self.cap:
                for i in range(1,len(self.dummys)): # 全是频次2的节点，需要将频次1的链表跳过
                    dummy=self.dummys[i]
                    if dummy.next==dummy:continue
                    remove_node = dummy.next
                    dummy.next=remove_node.next
                    remove_node.next.pre=dummy
                    self.d.pop(remove_node.k)
                    self.sz-=1
                    break
            # 添加当前节点           
            dummy=self.dummys[1]
            last_node = dummy.pre
            node = Node(key,value,1,last_node,dummy)
            last_node.next=node
            dummy.pre=node
            self.sz+=1
            self.d[key]=node