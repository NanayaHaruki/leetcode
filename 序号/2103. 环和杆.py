class Solution:
    def countPoints(self, rings: str) -> int:
        g=[0]*10
        for i in range(0,len(rings),2):
            color,idx=rings[i],int(rings[i+1])
            if color=='R':g[idx]|=1
            elif color=='G':g[idx]|=2
            else:g[idx]|=4
        return Counter(g)[7]