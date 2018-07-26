/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// 编写一个程序，找到两个单链表相交的起始节点。
// 例如，下面的两个链表：

// A:          a1 → a2
//                    ↘
//                      c1 → c2 → c3
//                    ↗            
// B:     b1 → b2 → b3
// 在节点 c1 开始相交。
// 注意：
// 如果两个链表没有交点，返回 null.
// 在返回结果后，两个链表仍须保持原有的结构。
// 可假定整个链表结构中没有循环。
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 链表A的长度是a+c，链表B的长度是b+c。两个指针走完A和B后，互换。 如图所示A的指针走到c3后走到b1去。
        // 这样指针A会在a+c+b后走到c1的位置。
        // 指针B会在b+c+a后走到c1的位置。
        // 即在a+b+c步后 两个指针会相遇。相遇点即为所求双链表相交点。如果c1为null，他们也同样会相交。
        ListNode a = headA;
        ListNode b = headB;
        if(a ==null || b == null) return null;
        while(a != b) {
        	a = a==null?headB:a.next;
        	b = b==null?headA:b.next;
        }
        return a;
    }
}
