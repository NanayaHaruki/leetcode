class Solution:
    def countPoints(self, points: List[List[int]], queries: List[List[int]]) -> List[int]:
        ans=[]
        for x,y,r in queries:
            cnt=0
            for i,j in points:
                if (x-i)**2+(y-j)**2<=r*r:
                    cnt+=1
            ans.append(cnt)
        return ans