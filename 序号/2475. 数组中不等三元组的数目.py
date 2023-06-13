class Solution:
    def unequalTriplets(self, nums: List[int]) -> int:
        cnt = Counter(nums)
        ans=0
        n=len(nums)
        a=0
        for v in cnt.values():
            ans+=a*v*(n-v-a) # 这个数字的数量 * 前面数字的数量 * 没遍历到的数字的数量
            a+=v
        return ans