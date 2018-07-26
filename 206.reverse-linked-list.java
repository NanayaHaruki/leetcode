/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 反转链表
 */
class Solution {
    public ListNode reverseList(ListNode head) {
    	// 用pre记录每次循环结果，每次循环将curr的当前数加到pre前面
    	// 1234  举例
        ListNode pre = null;
        ListNode curr = head;
        while(curr!=null) {
        	// 将next暂存起来
        	ListNode temp = curr.next; //暂存234
        	// 将当前的值放到pre之前
        	curr.next = pre;           //第一次pre为null  后面就是1   21  321了
        	pre = curr;                //将curr当前数 放到之前的pre前面去
        	curr = temp;               //curr为234继续循环
        }
        return pre;
    }
}
