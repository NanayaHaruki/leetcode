class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
      ListNode dummy(-101,head),*l=&dummy,*f=head;
      while(f){
        if(f->val==l->val){
          f=f->next;
        }else{
          l->next=f;
          l=f;f=f->next;
        }
      }
      l->next=nullptr;
      return dummy.next;
    }
};