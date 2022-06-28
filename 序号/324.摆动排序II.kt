fun wiggleSort(nums: IntArray): Unit {
  // 摆动排序，如果是偶数，找出较小的和较大的两堆树，一对一的排；如果是奇数，大数要比小树少，将中间的数放入小数堆里
  val l = nums.sorted()
  val minList = mutableListOf<Int>()
  val maxList = mutableListOf<Int>()
  var minSize = l.size / 2
  if (l.size % 2 == 1) minSize++ // 如果总共有奇数个数字，小数需要多一个
  val maxSize = l.size - minSize
  for (i in l.indices) {
    if (i < minSize) minList.add(l[i])
    else maxList.add(l[i])
  }
  for (i in 0 until maxSize) {
    nums[i * 2] = minList[minSize-1-i]
    nums[i * 2 + 1] = maxList[maxSize-1-i]
  }
  if (minSize > maxSize) nums[2 * maxSize] = minList[0]
}