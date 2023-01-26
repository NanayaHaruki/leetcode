class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        # 判断最左边深度和最右边深度，深度相同则为完全二叉树，节点数量为2**(depth+1)-1
        # 比如有3层，前1层节点数量二进制为001，前2层为011 前3层为111，前3层总数为1000-0001
        if not root:return 0
        n=root
        l=0
        while n.left:
            l+=1
            n=n.left
        n=root
        r=0
        while n.right:
            r+=1
            n=n.right
        if l==r:
            return 2**(l+1)-1
        else:
            return 1+self.countNodes(root.left)+self.countNodes(root.right)