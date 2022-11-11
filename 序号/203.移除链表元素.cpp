class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
      ListNode dummy(0,head),*p = &dummy,*f;
      while(p){
        f=p->next;
        while(f && f->val==val){
          f=f->next;
        }
        p->next=f;
        p=f;
      }
      return dummy.next;
    }
};