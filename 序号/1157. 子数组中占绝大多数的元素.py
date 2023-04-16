class MajorityChecker:

    def __init__(self, arr: List[int]):
        dct = defaultdict(list)
        for i, n in enumerate(arr):
            dct[n].append(i)
        self.lst = sorted(dct.items(), key=lambda it: len(it[1]),reverse = True)    # 倒序元组列表
        self.arr = arr

    def query(self, left: int, right: int, threshold: int) -> int:
        if left == right:    # 当给一个元素时，(0+1)/2<threshold<=1，即t=1,该元素必然返回
            return self.arr[left]
        if left+1 == right:    # 当给两个元素时，(1+1)/2<threshold<=(1+1),即t=2    
            return self.arr[left] if self.arr[left] == self.arr[right] else -1
        for n,n_list in self.lst:
            if len(n_list)<threshold:    # 先筛选掉原初数组出现次数少于t的元素
                break
            cur = bisect_right(n_list,right)-bisect_left(n_list,left)    # 在范围内的出现次数，如果是正确的下标相减还要+1但因为第一个函数所以+1免了
            # bisect_right(n_list,right)为列表中>r的第一个值的下标
            # bisect_left(n_list,left)为列表中>=l的第一个值的下标
            if cur >= threshold:
                return n
        return -1
