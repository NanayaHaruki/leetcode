
class Solution:
    def findSolution(self, customfunction: 'CustomFunction', z: int) -> List[List[int]]:
        a=1
        l,r=0,1001
        ans=[]
        for i in range(1,1001):
            l=0
            while l+1<r:
                mid = (l+r)//2
                res = customfunction.f(i,mid)
                if res==z:
                    ans.append([i,mid])
                    r=mid
                    break
                elif res<z:
                    l=mid
                else:
                    r=mid
        return ans