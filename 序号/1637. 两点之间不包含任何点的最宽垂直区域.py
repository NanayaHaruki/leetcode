class Solution:
    def maxWidthOfVerticalArea(self, points: List[List[int]]) -> int:
        points.sort()
        mx=0
        for i in range(len(points)-1):
            mx=max(mx,points[i+1][0]-points[i][0])
        return mx