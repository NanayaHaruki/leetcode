class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        pos, n = nums.index(k), len(nums)
        cnt, x = [0] * (n * 2), n
        cnt[x] = 1
        for i in range(pos - 1, -1, -1):  # 从 pos-1 开始累加 x
            x += 1 if nums[i] < k else -1
            cnt[x] += 1

        ans, x = cnt[n] + cnt[n - 1], n
        for i in range(pos + 1, len(nums)):  # 从 pos+1 开始累加 x
            x += 1 if nums[i] > k else -1
            ans += cnt[x] + cnt[x - 1]
        return ans

