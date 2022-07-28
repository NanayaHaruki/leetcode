fun arrayRankTransform(arr: IntArray): IntArray {
  // 根据大小，将arr中的数字映射成序号，从1开始
  val sortedArr = arr.sortedArray()
  var index = 1
  val d = mutableMapOf<Int, Int>()
  for (i in sortedArr) {
    if (!d.containsKey(i)) {
      d[i] = index++
    }
  }
  for (i in arr.indices) {
    sortedArr[i] = d[arr[i]]!!
  }
  return sortedArr
}