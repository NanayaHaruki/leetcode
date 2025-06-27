class Solution:
    # 392. 判断子序列
    # 返回 seq 是否为 s 的子序列
    def isSubsequence(self, seq: str, s: str) -> bool:
        it = iter(s)
        return all(c in it for c in seq)  # in 会消耗迭代器

    def longestSubsequenceRepeatedK(self, s: str, k: int) -> str:
        cnt = Counter(s)
        a = [ch for ch, freq in cnt.items() for _ in range(freq // k)]
        a.sort(reverse=True)

        for i in range(len(a), 0, -1):
            for perm in permutations(a, i):  # a 的长为 i 的排列
                seq = ''.join(perm)
                if self.isSubsequence(seq * k, s):  # seq*k 是 s 的子序列
                    return seq
        return ''