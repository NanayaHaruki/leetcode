/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeNodes(head: ListNode?): ListNode? {
        val h = head
        var cur=head
        var nxt = head?.next
        while(nxt!=null){
            // 把0后面的值累加到0这个节点上，将本来是0的节点链接起来
            if(nxt.`val`==0){
                if(nxt.next!=null){ // 最后一个0就不用连了
                    cur?.next=nxt
                    cur=nxt
                    
                }else {
                    cur?.next=null
                }
            }else{
                cur!!.`val`+=nxt.`val`
            }
            nxt=nxt.next
        }
        return h
    }
}