class NumArray:

    def __init__(self, nums: List[int]):
        n=len(nums)
        ns  = [0]*(n+1)
        for i in range(1,n+1):
            ns[i]=ns[i-1]+nums[i-1]
        self.ns=ns


    def sumRange(self, left: int, right: int) -> int:
        return self.ns[right+1]-self.ns[left]
