class Solution {
  struct Cmp {
    bool operator()(ListNode* a, ListNode* b) { return a->val > b->val; }
  };

 public:
  /** 每个链表都是升序，合并成一个升序链表 */
  ListNode* mergeKLists(vector<ListNode*>& lists) {
    // 思路1 有限队列
    priority_queue<ListNode*, vector<ListNode*>, Cmp> q;
    for (ListNode* node : lists) {
      while (node) {
        q.emplace(node);
        node = node->next;
      }
    }

    ListNode dummy;
    ListNode* p = &dummy;
    while (!q.empty()) {
      auto top = q.top();
      p->next = top;
      q.pop();
      p = p->next;
    }
    p->next = nullptr;
    return dummy.next;
  }
};