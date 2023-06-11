# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # 遍历时统计前缀和，搜索相反值前缀和存在不
        fake=ListNode(0)
        fake.next=head
        slow_sum={0:fake}
        s=0
        p=fake.next
        while p:
            s+=p.val
            if s in slow_sum: # s 这个前缀和曾经出现过，再次出现说明中间这一段必定为0
                slow_sum[s].next=p.next
                p=fake
                slow_sum={0:fake}
                s=0
            else:
                slow_sum[s]=p
            p=p.next 
        return fake.next