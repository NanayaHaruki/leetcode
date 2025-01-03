class MyCalendarTwo() {
  val d = TreeMap<Int,Int>()
  fun book(start: Int, end: Int): Boolean {
    // 区间修改，单点查询（其实是区间查询了，线段树太麻烦了，用差分做）
    // 先直接记录book，记录完了，利用差分计算是否有预定数量大于1的，有的说明重复了，本地预定取消即可
    // 因为不重合的，预定次数始终是1 -1 1 -1 1 -1 这样
    
    //---729 一样，不用导致三重预定，就是可以重复预定2次，把729的限制1，改成2即可-----
    d[start]=d.getOrDefault(start,0)+1
    d[end]=d.getOrDefault(end,0)-1
    
    var curValue = 0;var canBook = true
    for ((k,v) in d){
      curValue+=v
      if (curValue>2) {
        canBook=false
        break
      }
    }
    if (canBook) return true
    else {
      // 重复预定了，还原记录
      d[start] = d[start]!! -1
      d[end] = d[end]!!+1
      return false
    }
  }
}

/** 25/01/03 */
class MyCalendarTwo() {

  data class Node(val start:Int, val end:Int, var v:Int)
  private val kdTree = sortedSetOf<Node>(object:Comparator<Node>{
      override fun compare(o1: Node?, o2: Node?): Int {
          if (o1==null){
              if (o2==null){
                  return 0
              }else{
                  return -1
              }
          }else if(o2==null){
              return 1
          }
          return o1.start-o2.start
      }
  }).apply { add(Node(0,Int.MAX_VALUE,0)) }
  private fun split(x:Int):Node{
      val nodeX = Node(x,0,0)
      val greaterNode = kdTree.ceiling(nodeX)
      // 有现成的
      if (greaterNode!=null && greaterNode.start==x) return greaterNode
      val lowerNode = kdTree.lower(nodeX)!!
      val start = lowerNode.start
      val end = lowerNode.end
      val v = lowerNode.v
      kdTree.remove(lowerNode)
      kdTree.add(Node(start,x-1,v))
      val ans = Node(x,end,v)
      kdTree.add(ans)
      return ans
  }

  fun book(startTime: Int, endTime: Int): Boolean {
      val r = split(endTime)
      var l = split(startTime)
      val t= l
      // 先检查一遍有没有已经预定2次的了
      var ok = true
      while (l!=r){
          if (l.v<2){
              l=kdTree.higher(l)!!
              continue
          }
          ok=false
          break
      }
      if (!ok) return false
      // 将范围内的v都自增
      l=t
      while (l!=r){
          l.v++
          l=kdTree.higher(l)
      }
      return true
  }

}