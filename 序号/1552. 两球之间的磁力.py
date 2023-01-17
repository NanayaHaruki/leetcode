class Solution:
    def maxDistance(self, position: List[int], target: int) -> int:
        # 最小可能间距1，最大可能间距position[-1]-posision[0]
        # 二分找ans，从左到右扫position，看间距ans能否满足放得下m
        position.sort()
        n,l,r=len(position),0,position[-1]-position[0]+1
        
        while l+1<r:
            m = (l+r)//2
            cnt,pre=1,position[0]
            for i in range(1,n):
                if position[i]-pre>=m:
                    cnt+=1
                    pre = position[i]
            if cnt>=target:l=m
            else: r=m
        return l