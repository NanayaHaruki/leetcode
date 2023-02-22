class Solution {
  class Node(val l: Int, val r: Int, val v: Char) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
      return l - other.l
    }
  }


  val tree = TreeSet<Node>()
  val lenDict = TreeMap<Int, Int>()


  fun longestRepeating(s: String, queryCharacters: String, queryIndices: IntArray): IntArray {
    // 柯朵莉树维护连续区间，优先队列记录连续字符的长度，堆顶是最大长度
    fun updateLength(len: Int, diff: Int) {
      val v = lenDict.getOrDefault(len, 0) + diff
      if (v == 0) {
        lenDict.remove(len)
      } else {
        lenDict[len] = v
      }
    }
    var pre = ' '
    var idx = -1
    for (i in s.indices) { // 初始化柯朵莉树和优先队列
      if (s[i] != pre) {
        tree.add(Node(idx, i - 1, pre))
        updateLength(i - idx, 1)

        idx = i
        pre = s[i]
      }
    }
    tree.add(Node(idx, s.length - 1, pre))
    updateLength(s.length - idx, 1)
    tree.add(Node(s.length, s.length, ' '))
    val ans = IntArray(queryCharacters.length)
    for (i in queryCharacters.indices) { // 更改

      idx = queryIndices[i]
      val newChar = queryCharacters[i]
      val tmpNode = Node(idx, 0, ' ')
      val curNode = tree.floor(tmpNode)
      val preNode = tree.lower(tmpNode)
      if (curNode.l == idx ){ // 一样的，不用操作
        if (curNode.v==newChar){
          ans[i]=ans[i-1]
          continue
        }

      }else{
        if(preNode.v==newChar) {
          ans[i]=ans[i-1]
          continue
        }
      }
      if (curNode.l == idx) {
        // idx 正好是一段连续字符的开头
        val l = curNode.l
        val r = curNode.r
        val v = curNode.v
        if (l == r) {
          val nextNode = tree.higher(tmpNode)
          if (preNode.v == newChar && nextNode.v == newChar) {

            updateLength(preNode.r - preNode.l + 1, -1)
            updateLength(nextNode.r - nextNode.l + 1, -1)
            updateLength(1, -1)

            val pl = preNode.l
            val nr = nextNode.r
            tree.remove(preNode)
            tree.remove(curNode)
            tree.remove((nextNode))
            tree.add(Node(pl, nr, newChar))
            updateLength(nr - pl + 1, 1)
          } else if (preNode.v == newChar) {
            updateLength(preNode.r - preNode.l + 1, -1)
            updateLength(idx - preNode.l + 1, 1)
            val pl = preNode.l
            tree.remove(preNode)
            tree.remove(curNode)
            tree.add(Node(pl, idx, newChar))
          } else if (newChar == nextNode.v) {
            updateLength(nextNode.r - nextNode.l + 1, -1)
            updateLength(1, -1)
            updateLength(nextNode.r - idx + 1, 1)
            val nr = nextNode.r
            tree.remove(nextNode)
            tree.remove(curNode)
            tree.add(Node(idx, nr, newChar))
          } else {
            tree.remove(curNode)
            tree.add(Node(idx, idx, newChar))
          }
        } else { // 长度大于1
          // 缩短这个节点
          tree.remove(curNode)
          tree.add(Node(idx + 1, r, v))
          updateLength(r - l + 1, -1)
          updateLength(r - l, 1)
          if (newChar == preNode.v) { // 和前一个节点合并
            val pl = preNode.l
            tree.remove(preNode)
            tree.add(Node(pl, idx, newChar))
            updateLength(idx - pl, -1)
            updateLength(idx - pl + 1, 1)
          } else {
            tree.add(Node(idx, idx, newChar))
            updateLength(1, 1)
          }
        }
      } else {
        // preNode 包含了idx curNode.l > idx
        if (idx == preNode.r) { // preNode 的最后一个
          val nextNode = tree.higher(tmpNode)
          val pl = preNode.l
          val nr = nextNode.r
          if (newChar == nextNode.v) {// 考虑与后面node的结合
            updateLength(idx - pl + 1, -1)
            updateLength(nr - idx, -1)
            updateLength(nr - idx + 1, 1)
            tree.remove(preNode)
            tree.remove(nextNode)
            val pv = preNode.v
            tree.add(Node(pl, idx - 1, pv))
            tree.add(Node(idx, nr, newChar))
          } else {
            updateLength(idx - pl + 1, -1)
            updateLength(idx-pl,1)
            updateLength(1, 1)
            val pv = preNode.v
            tree.remove(preNode)
            tree.add(Node(pl, idx - 1, pv))
            tree.add(Node(idx, idx, newChar))
          }
        } else { // idx 在preNode中间
          val pl = preNode.l
          val pr = preNode.r
          val pv = preNode.v
          updateLength(idx - pl, 1)
          updateLength(pr - idx, 1)
          updateLength(1, 1)
          tree.remove(preNode)
          tree.add(Node(pl, idx - 1, pv))
          tree.add(Node(idx, idx, newChar))
          tree.add(Node(idx + 1, pr, pv))

        }
      }
      ans[i] = lenDict.lastKey()
    }
    return ans
  }
}