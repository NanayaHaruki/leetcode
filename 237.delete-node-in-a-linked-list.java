/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 请编写一个函数，使其可以删除某个链表中给定的（非末尾的）节点，您将只被给予要求被删除的节点。
// 比如：假设该链表为 1 -> 2 -> 3 -> 4  ，给定您的为该链表中值为 3 的第三个节点，那么在调用了您的函数之后，该链表则应变成 1 -> 2 -> 4 。

// 题意不明，删除节点不是应该给我一个原node，一个要删除的node，或者告诉我删除第几个node么，这参数就给一个是啥玩意
class Solution {
    public void deleteNode(ListNode node) {
    	if(node == null) return;
    	if(node.next ==null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
