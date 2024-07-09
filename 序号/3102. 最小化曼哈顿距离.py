class Solution:
    def minimumDistance(self, points: List[List[int]]) -> int:
        ''' 曼哈顿距离 |x1-x2|+|y1-y2|=max{
            x1-x2 + y1 - y2,
            x1-x2 + y2 - y1,
            x2-x1 + y1 - y2,
            x2-x1 + y2 - y1
        } = max{
            x1+y1 - (x2+y2),   ……1
            x1-y1 - (x2-y2),   ……2
            x2-y2 - (x1-y1),   ……3
            x2+y2 - (x1+y1)    ……4
        } ，
        把1和4放一起看，就是将每个点横纵坐标加，找最大的减最小的，得a;
        把2和3放一起看，就是将每个点横纵坐标差，找最大的减最小的，得b
        任意两点的最大距离就是max(a,b)
        题目要让移除一个点后，任意两点最大距离变小，那么移除这4个点是最好的（可能会重合，未必是4个）
        '''
        def dfs(j):
            minPlus,minMinus,maxPlus,maxMinus = inf,inf,-inf,-inf
            i1=i2=j1=j2=0
            for i,(x,y) in enumerate(points):
                if i==j:continue
                if x+y>maxPlus:
                    maxPlus=x+y
                    i2=i
                if x+y<minPlus:
                    minPlus=x+y
                    i1=i
                if x-y>maxMinus:
                    maxMinus=x-y
                    j2=i
                if x-y<minMinus:
                    minMinus=x-y
                    j1=i
            # 第1个是答案，即去掉索引为j的点之后，所有两点最大曼哈顿距离
            # 后面4个是极值点
            return max(maxPlus-minPlus,maxMinus-minMinus),i1,i2,j1,j2 
        
        return min(dfs(j)[0] for j in dfs(-1)[1:])
