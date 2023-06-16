class Solution:

    def minNumberOfSemesters(self, n: int, relations: List[List[int]], k: int) -> int:

        pre1 = [0] * n

        for x, y in relations:

            pre1[y - 1] |= 1 << (x - 1)  # y 的先修课程集合，下标改从 0 开始



        u = (1 << n) - 1

        f = [inf] * (1 << n)

        f[0] = 0

        for i in range(1, 1 << n):

            ci = u ^ i  # i 的补集

            i1 = 0

            for j, p in enumerate(pre1):

                if i >> j & 1 and p | ci == ci:  # p 在 i 的补集中，可以学（否则这学期一定不能学）

                    i1 |= 1 << j

            if i1.bit_count() <= k:  # 如果个数小于 k，则可以全部学习，不再枚举子集

                f[i] = f[i ^ i1] + 1

                continue

            j = i1

            while j:  # 枚举 i1 的子集 j

                if j.bit_count() == k:

                    f[i] = min(f[i], f[i ^ j] + 1)

                j = (j - 1) & i1

        return f[u]

