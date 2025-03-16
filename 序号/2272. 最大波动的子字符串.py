class Solution:
    def largestVariance(self, s: str) -> int:
        ans = 0
        f0 = [[0] * 26 for _ in range(26)]
        f1 = [[-inf] * 26 for _ in range(26)]
        for ch in map(ord, s):
            ch -= ord('a')
            # 遍历到 ch 时，只需计算 a=ch 或者 b=ch 的状态，其他状态和 ch 无关，f 值不变
            for i in range(26):
                if i == ch:
                    continue
                # 假设出现次数最多的字母 a=ch，更新所有 b=i 的状态
                f0[ch][i] = max(f0[ch][i], 0) + 1
                f1[ch][i] += 1
                # 假设出现次数最少的字母 b=ch，更新所有 a=i 的状态
                f1[i][ch] = f0[i][ch] = max(f0[i][ch], 0) - 1
                ans = max(ans, f1[ch][i], f1[i][ch])
        return ans
