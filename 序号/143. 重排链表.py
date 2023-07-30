class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        # 找中间节点，将后面节点反转，再合并
        s=f=head 
        while f and f.next:
            s=s.next      
            f=f.next.next
        def f(h):
            pre,cur=None,h
            while cur:
                nxt=cur.next
                cur.next=pre
                pre,cur=cur,nxt
            return pre
                
        tail = f(s)
      
        while tail.next:
            nh,nt =head.next,tail.next
            head.next=tail
            tail.next=nh
            head,tail=nh,nt
        return head