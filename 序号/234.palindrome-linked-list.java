/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 判定一个链表是否为回文  O(n) time and O(1) space
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(head.val);
        while (head.next != null) {
            list.add(head.next.val);
            head = head.next;
        }
        for (int i = 0; i < list.size(); i++) {
            Integer low = list.get(i);
            Integer high = list.get(list.size() - 1 - i);
            if ((low == null && high != null)
                    || (low != null && high == null)) {
                return false;
            } else if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
