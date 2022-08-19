class Solution {
  fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
    var ans = 0
    for(i in startTime.indices){
      if(queryTime in startTime[i]..endTime[i]) ans++
    }
    return ans
  }
}