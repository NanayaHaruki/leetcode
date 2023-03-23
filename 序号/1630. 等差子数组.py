class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        # l r 表示查询nums的索引范围，检查是否排序后是等差数列，
        m, n = len(l), len(nums)
        ans = [False] * m
        for i in range(m):
            curList = sorted(nums[l[i] : (r[i] + 1)])
            if len(curList) < 3:
                ans[i] = True
            else:
                d = curList[1] - curList[0]
                ok = True
                for j in range(2, len(curList)):
                    if curList[j] - curList[j - 1] != d:
                        ok = False
                        break
                ans[i] = ok
        return ans