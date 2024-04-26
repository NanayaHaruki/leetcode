class SnapshotArray:
    def __init__(self, length: int):
        self.data = {}
        self.id = 0

    def set(self, index: int, val: int) -> None:
        if index in self.data:
            v = self.data[index]
            if v[-1][0]==self.id:
                v[-1][1]=val
            else:
                v.append([self.id,val])
        else:
            self.data[index]=[[self.id,val]]


    def snap(self) -> int:
        # 没有必要没次都复制一遍数组，变更时记录下当前id和值，查询时根据id二分查找
        oid = self.id
        self.id+=1
        return oid


    def get(self, index: int, snap_id: int) -> int:
        if index not in self.data:
            return 0
        v = self.data[index]
        idx = bisect_left(v,[snap_id,0])
        if idx == len(v):
            return v[-1][1]
        if v[idx][0]==snap_id:
            return v[idx][1]
        if idx==0:
            return 0
        
        return v[idx-1][1]