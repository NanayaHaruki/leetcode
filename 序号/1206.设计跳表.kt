/*
执行用时：288 ms, 在所有 Kotlin 提交中击败了100.00% 的用户
内存消耗：51.7 MB, 在所有 Kotlin 提交中击败了100.00% 的用户
通过测试用例：20 / 20
* */
import kotlin.random.Random

class Skiplist() {
  val maxLevel = 32
  val p = 0.3
  val head = Node(-1, Array<Node?>(maxLevel) { null })
  
  class Node(val v: Int, val forwards: Array<Node?>)
  
  fun level(): Int {
    var ans = 1
    for (i in 0 until maxLevel) {
      if (Random.nextDouble() < p) ans++
      else break
    }
    return ans
  }
  
  fun search(target: Int): Boolean {
    val ns = find(target)
    return ns[0].forwards[0]?.v==target
  }
  
  fun add(num: Int) {
    // 找到每一层最靠近num的位置
    // 随机出num被加入到哪几层
    // 在遍历每一层，在最靠近num的位置，将num接在后面
    val nearest = find(num)
    val lv = level()
    val newNode = Node(num, Array(lv) { null })
    for (i in 0 until lv) {
      val next = nearest[i].forwards[i]
      if (next == null) nearest[i].forwards[i] = newNode
      else {
        newNode.forwards[i] = next
        nearest[i].forwards[i] = newNode
      }
    }
  }
  
  fun find(target:Int):Array<Node>{
    val updates = Array(maxLevel){head}
    var cur=head
    for (i in maxLevel-1 downTo 0){
      while(cur.forwards[i]!=null && cur.forwards[i]!!.v<target) cur = cur.forwards[i]!!
      updates[i]=cur
    }
    return updates
  }
  fun erase(num: Int): Boolean {
    val nearest = find(num)
    val node = nearest[0].forwards[0]
    if (node?.v!=num) return false
    for (i in 0 until maxLevel){
      if (nearest[i].forwards[i]==node)
        nearest[i].forwards[i]=node.forwards[i]
    }
    return true
  }
} 