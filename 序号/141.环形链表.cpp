class Solution {
 public:
  /** 破坏性找环 时间8 ms
击败
92.86%
内存7.8 MB
击败
84.53% */
  // bool hasCycle(ListNode *head) {
  //     if(head==nullptr) return false;
  //     while(head){
  //         if(head->val==10001) return true;
  //         head->val=10001;
  //         head=head->next;
  //     }
  //     return false;
  // }
  
  // 快慢指针
  bool hasCycle(ListNode *head) {
    if (head == nullptr) return false;
    ListNode * slow = head, * fast = head->next;
    while (fast!=nullptr && fast->next!=nullptr) {
      slow=slow->next;
      fast=fast->next->next;
      if(slow==fast) return true;
    }
    return false;
  }
};