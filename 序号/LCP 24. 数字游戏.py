class Solution:
    def numsGame(self, nums: List[int]) -> List[int]:
        n, mod = len(nums), 10 ** 9 + 7
        res = []
        minf, L, R = 0, [float("inf")], [float("inf")]
        for i in range(n):
            a = nums[i]
            minf += max(0, -L[0] + i - a)
            heapq.heappush(R, -heapq.heappushpop(L, -a + i))
            minf += max(0, a - R[0] - i)
            heapq.heappush(L, -heapq.heappushpop(R, a - i))
            res.append(minf % mod)
        return res