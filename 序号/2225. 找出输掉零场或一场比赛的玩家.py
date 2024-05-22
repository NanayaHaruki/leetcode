class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        cnt = Counter()
        mx = 0
        nums = set()
        for w,l in matches:
            cnt[l]+=1
            nums.add(w)
            nums.add(l)
        ans = [[] for _ in range(2)]
        for i in sorted(nums):
            if i not in cnt:
                ans[0].append(i)
            elif cnt[i]==1:
                ans[1].append(i)
        return ans