class Solution:
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        # 数据量只有500，统计每个点到其他点的距离，找到2个相同的点就是
        ans=0
        for i,(x1,y1) in enumerate(points):
            d={}
            for j,(x2,y2) in enumerate(points):
                if i==j:continue
                dis = (x1-x2)**2 + (y1-y2)**2
                if dis in d:
                    d[dis]+=1
                else:
                    d[dis]=1
            for v in d.values():
                if v>1:
                    # 组合公式，v中取2个，应该是v*(v-1)//2,
                    # 因回旋镖左右两边可交换，最终还要*2
                    ans+=v*(v-1)
        return ans
