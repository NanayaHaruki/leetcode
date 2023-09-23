class LockingTree:

    def __init__(self, parent: List[int]):
        self.p=parent
        self.d={}
        s={}
        for i,x in enumerate(parent):
            if x in s:
                s[x].add(i)
            else:
                s[x]={i}
        self.s=s


    def lock(self, num: int, user: int) -> bool:
        if num in self.d:return False
        self.d[num]=user
        return True

    def unlock(self, num: int, user: int) -> bool:
        if num in self.d and self.d[num]==user:
            self.d.pop(num)
            return True
        return False

    def upgrade(self, num: int, user: int) -> bool:
        p,s,c,d=self.p,self.s,num,self.d
        while c!=-1:# 检查父节点，有锁不行
             if c in d:return False
             c=p[c]
        q=deque()
        if num in s:
            for x in s[num]:
                q.append(x)
        findLock=[]
        while q:
            top=q.popleft()
            if top in d:# 检查子节点，有锁才行
                findLock.append(top)
            if top in s:
                for x in s[top]:
                    q.append(x)
        if findLock:
            self.d[num]=user
            for lock in findLock:
                self.d.pop(lock)
            return True
        return False



# Your LockingTree object will be instantiated and called as such:
# obj = LockingTree(parent)
# param_1 = obj.lock(num,user)
# param_2 = obj.unlock(num,user)
# param_3 = obj.upgrade(num,user)