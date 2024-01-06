class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def gcd(a,b):
            return a if not b else gcd(b,a%b)
        def lcm(a,b):
            return a*b//gcd(a,b)
        p = head
        while p.next:
            nxt=p.next
            p.next=ListNode(gcd(p.val,nxt.val),nxt)
            p=nxt
        return head