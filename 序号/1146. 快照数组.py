class SnapshotArray:

    def __init__(self, length: int):
        self.id=0
        self.d={}

    def set(self, index: int, val: int) -> None:
        if index in self.d:
            idx=bisect.bisect_left(self.d[index],(self.id,0))
            if idx==len(self.d[index]):
                self.d[index].append((self.id,val))
            else:
                print(self.d[index],idx)
                self.d[index][idx]=(self.id,val)
        else:
            self.d[index]=[(self.id,val)]
        

    def snap(self) -> int:
        rt=self.id
        self.id+=1
        return rt

    def get(self, index: int, snap_id: int) -> int:
        if index not in self.d:return 0
        l=self.d[index]
        idx= bisect.bisect_left(l,(snap_id,0))
        # idx 是如果snapId存在，则返回最左边的那个；如果不存在，返回的是snapId应该插入的位置，我们要的返回的是它之前被设置的值
        if idx==len(l):
            return l[-1][1] # 返回最后一次设置的值
        elif l[idx][0]==snap_id: # 正好查询的id就是插入的id
            return l[idx][1]
        elif idx==0:
            return 0 # 第一次设置比查询的id晚，返回初始值0     
        else: # 返回查询snapId之前被设置的值
            return l[idx-1][1]