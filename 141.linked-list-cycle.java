/**
 *给定一个链表，判断链表中否有环。
 *补充：
 *你是否可以不用额外空间解决此题？
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        // 开始让两个指针都指向开头
        ListNode slow = head;
        ListNode fast = head;
        // slow每次走一步，fast每次走两步。如果链表有环的话，fast必定先进环，然后再某个位置追上后进环的slow
        // fast在前面开路，只要判断fast的后两步不是null即可
        while(fast.next!=null && fast.next.next!=null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if(slow==fast) return true;
        }
    	return false;
    }
}

// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) {
//         val = x;
//         next = null;
//     }
// }
