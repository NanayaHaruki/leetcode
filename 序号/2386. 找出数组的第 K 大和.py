class Solution:
    def kSum(self, nums: List[int], k: int) -> int:
        # 第k大的子序列和，求出数组中所有正数的和就是最大的mx。
        # 用mx减去某个或某些正数，或者加上负数，得到较小的子序列和，将负数转正，用mx减去第k-1小的子序列和就是答案
        # 最小的子序列是空[]，和为0. 搞一个小堆，堆顶是是和最小的。
        # 给nums排序后往堆里添加数，从堆顶拿出来之前较小的，用较大的数替换前一个数，得到比较大的子序列和。以及不替换直接加上下个数，得到更大的子序列
        sm = 0
        n=len(nums)
        for i,x in enumerate(nums):
            if x>0:
                sm+=x
            else:
                nums[i]=-x
        nums.sort()
        h=[(0,0)] # 小堆，h[0][0]表达子序列和，h[0][1]表达下一个要添加的数的索引
        for _ in range(k-1):
            preSum,idx = heapq.heappop(h)
            if idx>=n:continue
            heapq.heappush(h,(preSum+nums[idx],idx+1))
            if idx>0:
                heapq.heappush(h,(preSum-nums[idx-1]+nums[idx],idx+1))
        return sm-h[0][0]