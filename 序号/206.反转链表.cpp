class Solution {
public:
    ListNode* reverseList(ListNode* head) {
      ListNode * cur=nullptr,*next=head;
      while(next!=nullptr){
        ListNode * nextnext= next->next;
        next->next=cur;
        cur=next;next=nextnext;
      }
      return cur;
    }
};