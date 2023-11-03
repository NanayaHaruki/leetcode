class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:return root
        q=deque([root])
        while q:
            sz = len(q)
            pre=Node(0,None,None,None)
            for _ in range(sz):
                next=q.popleft()
                pre.next=next
                pre=next
                if next.left:
                    q.append(next.left)
                if next.right:
                    q.append(next.right)
        return root