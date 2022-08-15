class CQueue() {
  val q1 = ArrayDeque<Int>() // 正序 用于插入
  val q2 = ArrayDeque<Int>() // 倒序 用于弹出
  // 需要弹出时，将q1加入q2，弹出。当需要插入时，将q2挪入q1，进行插入
  fun appendTail(value: Int) {
    while(q2.isNotEmpty()) q1.add(q2.removeLast())
    q1.add(value)
  }
  
  fun deleteHead(): Int {
    while(q1.isNotEmpty()) q2.add(q1.removeLast())
    return if(q2.isNotEmpty()) q2.removeLast() else -1
  }
}