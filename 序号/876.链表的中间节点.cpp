class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        // 返回中间节点，快慢指针
        ListNode * slow = head,*fast = head;
        while(fast && fast->next){
            fast = fast->next->next; // 总节点为偶数时，fast最后一步不能走出二步
            slow = slow->next;
        }
        return slow;
    }
};