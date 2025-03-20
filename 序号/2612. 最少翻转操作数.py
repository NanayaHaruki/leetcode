class UnionFind:
    def __init__(self, n: int):
        self.fa = list(range(n))

    def find(self, x: int) -> int:
        if self.fa[x] != x:
            self.fa[x] = self.find(self.fa[x])
        return self.fa[x]

    def merge(self, from_: int, to: int) -> None:
        self.fa[self.find(from_)] = self.find(to)

class Solution:
    def minReverseOperations(self, n: int, p: int, banned: List[int], k: int) -> List[int]:
        indices = UnionFind(n + 2)
        indices.merge(p, p + 2)  # 删除 p
        for i in banned:
            indices.merge(i, i + 2)  # 删除 i

        ans = [-1] * n
        ans[p] = 0
        q = deque([p])
        while q:
            i = q.popleft()
            mn = max(i - k + 1, k - i - 1)
            mx = min(i + k - 1, n * 2 - k - i - 1)
            j = indices.find(mn)
            while j <= mx:
                ans[j] = ans[i] + 1
                q.append(j)
                indices.merge(j, mx + 2)  # 删除 j
                j = indices.find(j + 2)  # 快速跳到 >= j+2 的下一个下标
        return ans