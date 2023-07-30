class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # 起点到环入口为a， 快慢指针相遇点离入口距离b，环长c
        # 慢指针总路程a+b。不会是a+b+n*c，当慢指针到达入口时，快指针假设离入口d，c-d步后快指针追上慢指针，此时慢指针走了c-d步，没到一圈
        # 快指针总路程a+b+n*c，但速度是慢指针两倍，也可以表达为2(a+b),a+b+n*c=2(a+b) => a+b=nc
        # 起点到入口的距离nc-b，慢指针在走nc- b后正好回到入口
        s=f=head
        while f and f.next:
            s=s.next
            f=f.next.next
            if s==f:# 相遇，重新出发一个节点
                while head!=s: 
                    head=head.next
                    s= s.next
                return s
        return None

        # 方法一 哈希
        # d=set()
        # p=head
        # while p:
        #     if p in d:
        #         return p
        #     d.add(p)
        #     p=p.next
        # return None