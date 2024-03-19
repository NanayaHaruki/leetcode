class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        q = deque([(0,-1)])  # q[i][0]是高度，q[i][1]是左边更低高度的索引
        ans=0
        heights.append(0)
        for i,r in enumerate(heights):
            while q and r<q[-1][0]:
                m,_ = q.pop()
                l,j = q[-1]
                area = m*(i-j-1) # 找到左右两边更小的，中间的就是宽，m为高
                ans=max(ans,area)
            q.append((r,i))
        return ans