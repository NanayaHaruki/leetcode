class Solution:
    def minimumRefill(self, plants: List[int], capacityA: int, capacityB: int) -> int:
        n=len(plants)
        l,rl,r,rr = -1,capacityA,n,capacityB
        ans=0
        while l<r:
            if l+1==r-1: # 谁水多谁来，一样多左边的来
                if rl>=rr:
                    if plants[l+1]>rl:
                        ans+=1
                else:
                    if plants[l+1]>rr:
                        ans+=1
                break
            if l+1==r:
                break
            if plants[l+1]>rl:
                ans+=1
                rl=capacityA-plants[l+1]
            else:
                rl-=plants[l+1]
            if plants[r-1]>rr:
                ans+=1
                rr=capacityB-plants[r-1]
            else:
                rr-=plants[r-1]
            l,r=l+1,r-1
        return ans