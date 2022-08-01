class Solution {
  fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
    var h = ListNode(0,head)
    val t = h
    while(h!=null && h?.next?.`val`!=`val`){
      h=h.next
    }
    h?.next = h?.next?.next
    return t?.next
  }
}