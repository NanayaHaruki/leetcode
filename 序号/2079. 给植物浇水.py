class Solution:
    def wateringPlants(self, plants: List[int], capacity: int) -> int:
        ans=0
        n=len(plants)
        remain = capacity
        for i,x in enumerate(plants):
            ans+=1
            remain-=x
            if i==n-1:break
            if remain>=plants[i+1]:
                continue
            ans+=(i+1)*2
            remain=capacity
        return ans