class Solution {
  
  fun minMutation(start: String, end: String, bank: Array<String>): Int {
    // 从start 到end需要几步 每次动一个字符
    // 在bank中找变一个的，看有没有end，没有找变2步的  bfs
    val q = getChange1CharQueue(start,bank)
    var ans = 1
    while (ans<=10){
      var find = false
      val nextQueue = ArrayDeque<String>()
      while (q.isNotEmpty()){
        val first = q.removeFirst()
        if (first==end) {
          find = true
        }else{
          val curNextQueue = getChange1CharQueue(first,bank)
          nextQueue.addAll(curNextQueue)
        }
      }
      if (find) break
      q.addAll(nextQueue)
      nextQueue.clear()
      ans++
    }
    return if(ans>10) -1 else ans
  }
  
  fun getChange1CharQueue(a:String,bank: Array<String>):ArrayDeque<String>{
    val q = ArrayDeque<String>()
    for (str in bank) if (check(a,str)) q.add(str)
    return q
  }
  
  /** 检查只变了一个字符 */
  fun check(a:String,b:String):Boolean{
    var changeCnt = 0
    for (i in a.indices){
      if (a[i]!=b[i]) changeCnt++
    }
    return changeCnt==1
  }
}