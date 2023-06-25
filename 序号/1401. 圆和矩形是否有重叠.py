class Solution:
    def checkOverlap(self, radius: int, xCenter: int, yCenter: int, x1: int, y1: int, x2: int, y2: int) -> bool:
        # 矩形到圆的距离为 sqrt((xi-xc)^2+(yi-yc)^2) ,求这个值取最小时是否<半径radius
        # xc<x1 圆在左边，（xi-xc)^2 最小值为(x1-xc)^2; x1<=xc<=x2，圆在上方，(xi-xc)^2 最小值为0; xc>x2, (xi-xc)^2 为最小值(xc-x2)^2
        if xCenter<x1:
            x=x1-xCenter
        elif xCenter>x2:
            x=xCenter-x2
        else:
            x=0
        if yCenter<y1:
            y=y1-yCenter
        elif yCenter>y2:
            y=yCenter-y2
        else:
            y=0
        return x**2+y**2<=radius**2