class Solution:
    def magicTower(self, nums: List[int]) -> int:
        if sum(nums)<0:return -1
        # 没血了就把前面扣最多的挪后面，再把血加回来
        q=[]
        ans=0
        hp=1
        for x in nums:
            if x<0: heapq.heappush(q,x)
            hp+=x
            if hp<1:
                ans+=1
                hp-=heapq.heappop(q)
        return ans