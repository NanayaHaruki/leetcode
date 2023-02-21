class Solution:
    def minTaps(self, n: int, ranges: List[int]) -> int:
        # 将每个水龙头能灌溉的范围以左边界排序，贪心让左边界与前一个水龙头的右边界连续的同时，自己的右边界尽可能的大
        lens=[0]*(n+1)
        for i,r in enumerate(ranges):
            left,right=max(0,i-r),min(n,i+r)
            lens[left]=max(lens[left],right)
        ans,l,r=1,lens[0],lens[0]
        for i in range(1,n+1):
            if i<l:
               r=max(r,lens[i])
            elif i==l:
                if i!=n:
                    ans+=1
                    r=max(r,lens[i])
                    l=r
                    
            else:
                return -1
        return ans