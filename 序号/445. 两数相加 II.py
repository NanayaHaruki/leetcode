class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        a,b=[],[]
        while l1:
            a.append(l1.val)
            l1=l1.next
        while l2:
            b.append(l2.val)
            l2=l2.next
        ia,ib=len(a)-1,len(b)-1
        ans=ListNode()
        cur=a[ia]+b[ib]
        if cur>9:
            ans.val=cur%10
            j=1
        else:
            ans.val=cur
            j=0
        ia-=1;ib-=1
        while ia>=0 or ib>=0:
            pre=ListNode()
            pre.next=ans
            ans=pre
            cur=j
            if(ia>=0):
                cur+=a[ia]
                ia-=1
            if(ib>=0):
                cur+=b[ib]
                ib-=1
            if cur>9:
                ans.val=cur%10
                j=1
            else:
                ans.val=cur
                j=0
        if j:
            pre=ListNode(1)
            pre.next=ans
            ans=pre
        return ans