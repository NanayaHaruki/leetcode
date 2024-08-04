class Solution:
    def maxPointsInsideSquare(self, points: List[List[int]], s: str) -> int:
        ans=0
        lmt = inf # 统计限制（a距离为1，另一个a距离为2，2就是最大限制）
        points_distance={} # 保存每个字符到（0，0）的最小距离，只保留距离最小的
        
        for (x,y),c in zip(points,s):
            if c not in points_distance:
                points_distance[c]=max(abs(x),abs(y))
            else:
                cur_dis = max(abs(x),abs(y))
                if points_distance[c]>cur_dis:
                    lmt=min(lmt,points_distance[c])
                    points_distance[c]=cur_dis
                else:
                    lmt=min(lmt,cur_dis)
        # 根据最小的点，统计在限制内能装下多少个字符（标签）
        dis = sorted(list(points_distance.values()))
        for d in dis:
            if d < lmt:
                ans+=1
            else:
                break
        
        return ans