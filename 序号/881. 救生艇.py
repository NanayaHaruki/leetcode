
class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        n = len(people)
        l,r=0,n-1
        ans=0
        while l<r:
            if people[r]==limit or people[l]+people[r]>limit:
                ans+=1
                r-=1
                continue
            ans+=1
            l+=1
            r-=1
        if l==r:
            ans+=1
        return ans 

