/** 长度相同两数组， 重新排列nums1，尽量让相同索引的值比nums2大 nums1[i]>=0*/

// 执行用时：824 ms, 在所有 Kotlin 提交中击败了16.67% 的用户
// 内存消耗：56.6 MB, 在所有 Kotlin 提交中击败了16.67% 的用户
// 通过测试用例：67 / 67
fun advantageCount(nums1: IntArray, nums2: IntArray): IntArray {
  // 贪心，尽量找比nums2大的最小值
  val tree = TreeMap<Int,ArrayDeque<Int>>()
  var num:Int
  for (i in nums1.indices){
    num = nums1[i]
    val q = tree.getOrDefault(num,ArrayDeque(1))
    q.add(i)
    tree[num]=q
  }
  
  val notFitIndexQueue = ArrayDeque<Int>()
  for (i in nums2.indices){
    num = nums2[i]
    val entry = tree.higherEntry(num)
    if (entry==null) notFitIndexQueue.add(i)
    else {
      nums1[i]=entry.key
      if(entry.value.size==1) tree.remove(entry.key)
      else entry.value.removeFirst()
    }
  }
  while(notFitIndexQueue.isNotEmpty()){
    val index = notFitIndexQueue.removeFirst()
    val entry = tree.firstEntry()
    nums1[index]=entry.key
    if (entry.value.size==1) tree.remove(entry.key)
    else {
      entry.value.removeFirst()
    }
  }
  return nums1
}