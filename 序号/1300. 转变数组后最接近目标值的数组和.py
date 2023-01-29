class Solution:
    def findBestValue(self, arr: List[int], target: int) -> int:
        # 二分尝试某一个答案x，找到arr中大于x的数k个，用前缀和求出这k个数的和，k*x为修改后的和，加上arr<=x那部分的和
        # 计算修改后的总和与target的差，题目要求最小的x，满足条件锁右边界
        arr.sort()
        l, r, n = 0, arr[-1], len(arr)
        ps = list(accumulate(arr))
        def getSum(v):
            i = bisect.bisect_right(arr, v)
            j = n - i
            leftSum=0
            if i:
                leftSum=ps[i-1]
            rightSum=v*j
            return leftSum+rightSum
        while l + 1 < r:
            m = (l + r) // 2
            if getSum(m)>=target:
                r=m
            else:
                l=m
        a=r
        while l + 1 < r:
            m = (l + r) // 2
            if getSum(m)<=target:
                l=m
            else:
                r=m
        b=l
        if abs(getSum(a)-target)<abs(getSum(b)-target):
            return a
        else:
            return b