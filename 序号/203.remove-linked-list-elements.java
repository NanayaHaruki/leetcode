/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 删除链表中等于给定值 val 的所有元素。

// 示例
// 给定: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
// 返回: 1 --> 2 --> 3 --> 4 --> 5
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        // 一直递归到最深层，直到返回null
        head.next = removeElements(head.next,val);
        // 最深层此时的next为null，次深层为val则返回null，否则返回自身；
        // 因为从深层传上来，非最深层此时的next是没有val的ListNode了，判断自身是否为val，如果是则指向next，不是返回自身，继续向上层传导；
        return head.val == val?head.next:head;
    }
}
