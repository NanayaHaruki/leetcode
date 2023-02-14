class Solution {
  fun longestWPI(hours: IntArray): Int {
    // 前缀和统计劳累天数，
    val n = hours.size
    val ps = IntArray(n + 1)
    for (i in 1..n) {
      ps[i] = ps[i - 1] + if (hours[i - 1] > 8) 1 else 0
    }
    // 没有单调性，只能从高往下检查
    for(i in n downTo 0){
      for (j in i..n){
        val tiredDays = ps[j]-ps[j-i]
        val notTiedDays = i-tiredDays
        if(tiredDays>notTiedDays){
          return i
        }
      }
    }
    return 0
  }
}