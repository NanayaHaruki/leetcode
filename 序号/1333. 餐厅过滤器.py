class Solution:
    def filterRestaurants(self, restaurants: List[List[int]], veganFriendly: int, maxPrice: int, maxDistance: int) -> List[int]:
        ans=[]
        for i,r in enumerate(restaurants):
            if r[3]<=maxPrice and r[4]<=maxDistance:
                if veganFriendly==0 or r[2]:
                    ans.append(i)
        ans.sort(key=lambda i:(-restaurants[i][1],-restaurants[i][0]))
        for i,x in enumerate(ans):
            ans[i]=restaurants[x][0]
        return ans