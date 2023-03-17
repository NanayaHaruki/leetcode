class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        # 返回子序列和 <= q[i] 的最大长度
        # 1. 子序列之和，不要求连续 也不要求位置； 先排序 再前缀和 最后二分求解
        nums.sort()
        ps = list(itertools.accumulate(nums))
        n,m = len(queries),len(nums)
        ans=[0]*n
        for i in range(n):
            l,r=-1,m
            while l+1<r:
                mid=(l+r)//2
                if ps[mid]<=queries[i]:
                    l=mid
                else:
                    r=mid
            ans[i]=r
        return ans
