# 给定一个二叉树，检查它是否是镜像对称的。
#
# 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
#
#     1
#    / \
#   2   2
#  / \ / \
# 3  4 4  3
# 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
#
#     1
#    / \
#   2   2
#    \   \
#    3    3
# 说明:
#
# 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。



# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        else:
            return self.isMirror(root.left, root.right)

    def isMirror(self, node1: TreeNode, node2: TreeNode):
        if node1 and not node2:
            return False
        elif not node1 and node2:
            return False
        elif not node1 and not node2:
            return True
        elif node1.val != node2.val:
            return False
        else:
            return self.isMirror(node1.left, node2.right) and self.isMirror(node1.right, node2.left)


if __name__ == '__main__':
    and_ = 1 and 1 / 0
    print(and_)
