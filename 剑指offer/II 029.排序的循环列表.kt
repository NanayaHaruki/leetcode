fun insert(head: Node?, insertVal: Int): Node? {
  // head 为循环非降序链表，将insertVal插入相应位置
  
  if (head == null) {
    val n = Node(insertVal)
    n.next = n
    return n
  }
  
  // 记录最值位置
  var cur = head;
  var min = head;
  var max = head
  while (true) {
    if (cur!!.`val` < min!!.`val`) min = cur
    if (cur.`val` >= max!!.`val`) max = cur //max可能有多个，要更新到最后一个
    cur = cur.next
    if (cur == head) break
  }
  if (min == max) {
    // 等值链表，随便插
    link(insertVal, min!!)
  } else {
    // 不管新插入的是新的极大值还是极小值，都是插在旧的最大值后面
    if (insertVal > max!!.`val` || insertVal < min!!.`val`) {
      link(insertVal, max)
    } else {
      // 非极值找到中间节点
      cur = min
      while (true) {
        if (cur!!.next!!.`val`>=insertVal) break
        cur=cur.next
      }
      // 此时cur的下一个就比interval大了
      link(insertVal,cur!!)
    }
  }
  return head
}

fun link(insertVal: Int, preNode: Node) {
  val n = Node(insertVal)
  n.next = preNode.next
  preNode.next = n
}