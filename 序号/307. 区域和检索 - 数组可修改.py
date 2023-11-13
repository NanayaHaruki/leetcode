class NumArray:

    def lowerbit(self,x:int):
        return x&-x
    def __init__(self, nums: List[int]):
        n = len(nums)
        arr=[0]*(n+1)
        for i in range(1,n+1):
            arr[i]+=nums[i-1]
            j=i+self.lowerbit(i)
            if j<=n:
                arr[j]+=arr[i]
        self.arr=arr
        self.nums=nums
        self.n=n

    def updateTree(self,i,dx):
        while i<=self.n:
            self.arr[i]+=dx
            i+=self.lowerbit(i)

    def sum(self,i):
        ans=0
        while i>0:
            ans+=self.arr[i]
            i-=self.lowerbit(i)
        return ans

    def update(self, index: int, val: int) -> None:
        old=self.nums[index]
        dx=val-old
        self.nums[index]=val
        self.updateTree(index+1,dx)

    def sumRange(self, left: int, right: int) -> int:
        return self.sum(right+1)-self.sum(left)
# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(index,val)
# param_2 = obj.sumRange(left,right)