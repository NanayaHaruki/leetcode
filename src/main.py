from typing import List
from collections import Counter, defaultdict, deque
import math
import itertools
from functools import cache

class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        # 逐层统计 node 子树大小
        def count_subtree_size(node: int) -> int:
            size = 0
            left, right = node, node + 1
            while left <= n:
                # 这一层的最小值是 left，最大值是 min(right, n + 1) - 1
                size += min(right, n + 1) - left
                left *= 10  # 继续，计算下一层
                right *= 10
            return size

        node = 1
        k -= 1  # 访问节点 node
        while k > 0:
            size = count_subtree_size(node)
            if size <= k:  # 向右，跳过 node 子树
                node += 1  # 访问 node 右侧兄弟节点
                k -= size  # 访问子树中的每个节点，以及新的 node 节点
            else:  # 向下，深入 node 子树
                node *= 10  # 访问 node 的第一个儿子
                k -= 1  # 访问新的 node 节点
        return node



# c = Solution().findKthNumber(681692778,351251360)
print(len('00000000000001000000000001000000000000000000000000000000000000000000000000000000000000000000'))