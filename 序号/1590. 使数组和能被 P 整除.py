class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        '''
        前缀和+两数之和
        '''

        n = len(nums)
        ps = [0]*(n+1)
        for i in range(1,n+1):
            ps[i]=ps[i-1]+nums[i-1]
        t = ps[-1]%p # t 即为要删掉的子数组之和模p的目标
        if t==0:return 0
        d={}
        ans=n
        for i in range(n+1):
            pre = (ps[i]-t+p)%p
            if pre in d:
                ans=min(ans,i-d[pre])
            d[ps[i]%p]=i
        return -1 if ans ==n else ans