class Solution:
    def minimumSeconds(self, nums: List[int]) -> int:
        # 每秒，每个数都可以变成左右的数，数组有环
        # 统计每个数的位置，假定都要变成x，
        # O 计算x扩散到整个数组需要多久
        # X 当前是nums[i],找离i最近的x出现在哪，整个数组的最长距离就是答案 
        n=len(nums)
        indices = defaultdict(list)
        for i,x in enumerate(nums):
            indices[x].append(i)
        ans=n
        for v in indices.values():
            v.append(v[0]+n)
            mx=0
            for i in range(1,len(v)):
                mx=max(v[i]-v[i-1],mx)
            ans=min(ans,mx//2)
        return ans