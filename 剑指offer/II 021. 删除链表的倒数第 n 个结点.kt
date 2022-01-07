import java.util.ArrayDeque

class Solution {
    fun removeNthFromEnd(_head: ListNode?, n: Int): ListNode? {
        // 删掉倒数第N个节点
        // 用个队列存储n+1个节点，遍历不断更新，遍历完将第一个与第3个连接即可
        val q = ArrayDeque<ListNode>(n + 1)
        var head = _head
        while (head != null) {
            if (q.size < n + 1) {
                q.offerLast(head)
            } else {
                q.pollFirst()
                q.offerLast(head)
            }
            head = head.next
        }
        return if (q.size > n) {
            q.first.next = q.first.next?.next
            _head
        } else {
            q.first.next
        }
    }
}