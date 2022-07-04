fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
  // 返回最小差的数对
  arr.sort()
  val ans = mutableListOf<List<Int>>()
  for (i in 1 until arr.size){
    val diff = arr[i]-arr[i-1]
    if (ans.isEmpty()) ans.add(listOf(arr[i-1],arr[i]))
    else {
      val preDiff = ans[0][1]-ans[0][0]
      if (diff<preDiff){
        ans.clear()
        ans.add(listOf(arr[i-1],arr[i]))
      }else if(diff ==preDiff){
        ans.add(listOf(arr[i-1],arr[i]))
      }
    }
  }
  return ans
}