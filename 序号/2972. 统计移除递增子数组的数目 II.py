class Solution:
    def incremovableSubarrayCount(self, nums: List[int]) -> int:
        # 一个递增数组长度为n，删任何一个子数组都还是递增的，删子数组的长度为n，有1种
        # 删子数组长度为1，有n种方法，总共有（1+n)*n/2

        # 后缀如果不是递增，0 1 2 3 1 1，递增到索引3，可以从索引4开始删，当然也可以从索引3、索引2开始删
        # 可能性有i+2种

        # 如果后缀也递增，并且后缀的第一个比前缀的最后一个大，那么挖掉中间一段也行。
        # 并且中间这段可以向两边扩大，剩下的数组仍然是递增的
        # 0 1 2 3 （1 2） 4 5 6，挖的12 挖123  挖312 都可以
        # 用固定后缀的方式来统计
        n = len(nums)
        # 统计前缀的最大长度
        i = 0
        while i+1<n and nums[i]<nums[i+1]:i+=1
        if i==n-1:return n*(n+1)//2
        j=n-1
        ans=i+2
        while j==n-1 or nums[j]<nums[j+1]:
            while i>=0 and nums[i]>=nums[j]:
                i-=1
            ans+=i+2
            j-=1
        return ans