class Solution {
 public:
  /** 删除倒数第n个节点 */
  ListNode* removeNthFromEnd(ListNode* head, int n) {
    // 滑动窗口
    ListNode *fakeHead = new ListNode(0,head);
    ListNode *pop=fakeHead;
    ListNode *p=fakeHead->next;
    deque<ListNode *> q;
    while(p){
      if(q.size()<n) q.emplace_back(p);
      else {
        pop=q.front();
        q.pop_front();
        q.emplace_back(p);
      }
      p=p->next;
    }
    if (n > 1) pop->next = q[1];
    else pop->next = nullptr;
    ListNode * ans = fakeHead->next;
    delete fakeHead;
    return ans;
  }
};