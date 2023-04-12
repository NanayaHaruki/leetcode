class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # 方法二 快慢指针，有环快指针必然会绕环一周追上慢指针；
        # 起点到环入口距离为a，慢指针沿环走了b，环周长为c。 快指针走了a+c+b ,慢指针走了a+b，即a+b+c=2(a+b) => c=a+b; 快慢指针相遇处，慢指针走的距离刚好时环长
        # 慢指针还需要再次走a，就可以回到环的入口处。此时从head重新出发一个指针，走到环入口也是a，则新指针和慢指针相遇的地方就是入口

        slow,fast,new=head,head,head
        while fast and fast.next:
            fast=fast.next.next
            slow=slow.next
            if slow==fast: # 相遇了，fast没用了，slow去找new玩
                break
        if not (fast and fast.next):return None
        while new!=slow:
            new=new.next
            slow=slow.next
        return new

        # 方法一 哈希
        # d=set()
        # p=head
        # while p:
        #     if p in d:
        #         return p
        #     d.add(p)
        #     p=p.next
        # return None