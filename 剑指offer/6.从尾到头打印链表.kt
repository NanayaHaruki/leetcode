fun reversePrint(h: ListNode?): IntArray {
  val  q = ArrayDeque<Int>();var head=h
  while(head!=null){
    q.add(head.`val`)
    head=head.next
  }
  val ans = IntArray(q.size)
  var i = 0
  while (q.isNotEmpty()){
    ans[i++]=q.removeLast()
  }
  return ans
}