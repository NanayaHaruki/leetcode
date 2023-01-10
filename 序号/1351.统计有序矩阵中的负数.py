class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        # # 正序 时间 nlogm
        # m,n=len(grid),len(grid[0])
        # ans=0
        # for i in range(m):
        #     l,r=0,n-1
        #     while l<=r:
        #         m=(l+r)//2
        #         if grid[i][m]>=0:
        #             l=m+1
        #         else:
        #             r=m-1
        #     ans+=(n-l)
        # return ans

        # grid 向右向下非递减，从最下面遍历找到负数点，上一行没必要从0开始二分，可以从当前点正上方开始
        ans, m, n = 0, len(grid), len(grid[0])
        l = 0
        for i in range(m - 1, -1, -1):
            r = n - 1  # l 为下一行二分出来的点，r 每次要恢复到行末
            while l <= r:
                mid = (l + r) // 2
                if grid[i][mid] >= 0:
                    l = mid + 1
                else:
                    r = mid - 1
            ans += n - l
        return ans

