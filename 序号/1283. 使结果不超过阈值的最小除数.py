class Solution:
    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        l,r=0,int(1e6+1)
        while l+1<r:
            m=(l+r)//2
            sum=0
            for i in nums:
                sum+=i//m
                if i%m:
                    sum+=1
            if sum<=threshold:
                r=m
            else:
                l=m
        return r