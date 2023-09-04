class Codec:
    # 利用后序直接还原bst
    def serialize(self, root: Optional[TreeNode]) -> str:
        ans=[]
        def postOrder(rt:TreeNode):
            if not rt:return
            postOrder(rt.left)
            postOrder(rt.right)
            ans.append(rt.val)
        postOrder(root)
        return str(ans)

    def deserialize(self, data: str) -> Optional[TreeNode]:
        if len(data==2):return None
        l = list(map(int,data[1:-1].split(',')))
        def build(mn,mx):
            if not l or l[-1]<mn or l[-1]>mx:return None
            node = TreeNode(l.pop())
            node.right=build(node.val,mx)
            node.left=build(mn,node.val)
            return node
        return build(-math.inf,math.inf)
    # 利用前序和中序 还原二叉树
    # def serialize(self, root: Optional[TreeNode]) -> str:
    #     """Encodes a tree to a single string.
    #     """
    #     def pre_order(root:TreeNode):
    #         ans=[]
    #         if not root: return ans
    #         ans.append(root.val)
    #         return ans+pre_order(root.left)+pre_order(root.right)
    #     return str(pre_order(root))
        
    # def deserialize(self, data: str) -> Optional[TreeNode]:
    #     """Decodes your encoded data to tree.
    #     """
    #     if len(data)==2:return None # []空的
    #     pre_order = list(map(int,data[1:-1].split(',')))
    #     in_order=sorted(pre_order) # bst性质

    #     def build(l1,r1,l2,r2):
    #         if l1>r1 or l2>r2:return None
    #         rtIdx=in_order.index(pre_order[l1],l2,r2+1)
    #         leftLen = rtIdx-l2
    #         root = TreeNode(pre_order[l1])
    #         root.left=build(l1+1,l1+leftLen,l2,rtIdx-1)
    #         root.right=build(l1+leftLen+1,r1,rtIdx+1,r2)
    #         return root
    #     return build(0,len(pre_order)-1,0,len(in_order)-1)