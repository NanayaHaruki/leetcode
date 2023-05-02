class Solution:
    def powerfulIntegers(self, x: int, y: int, bound: int) -> List[int]:
        if bound==0:
            return []
        i=j=0
        ans=set()
        for i in range(1 if x==1 else int(math.log(bound,x))+1):
            for j in range(1 if y==1 else int(math.log(bound,y))+1):
                z=x**i+y**j
                if z<=bound:
                    ans.add(int(z))
                else:
                    break
        return list(ans)