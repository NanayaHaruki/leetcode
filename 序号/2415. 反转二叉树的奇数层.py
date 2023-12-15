# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        # 将每层节点存起来 
        l=[]
        q=deque([root])
        while q:
            sz = len(q)
            curLayer = []
            for _ in range(sz):
                node = q.popleft()
                curLayer.append(node)
                if node.left: # 完全二叉树
                    q.append(node.left)
                    q.append(node.right)
            l.append(curLayer)
        # 更改奇数层倒序，其实就是更改偶数层的子节点
        for i in range(len(l)-1):
            cur,nxt=l[i],l[i+1]
            if i&1: # 奇数层本身顺序反转，但下一层不变，需要修改奇数自己的子节点，第一个节点的子节点变成最后一个节点的子节点 
                p=len(nxt)-2
                for j in range(len(cur)):
                    cur[j].left=nxt[p]
                    cur[j].right=nxt[p+1]
                    p-=2
            else:
                p=len(nxt)-1
                for j in range(len(cur)):
                    cur[j].left=nxt[p]
                    cur[j].right=nxt[p-1]
                    p-=2
        return root

