class Solution {
  fun maxRunTime(_n: Int, batteries: IntArray): Long {
    var sum = 0L
    var n = _n
    for(b in batteries) sum+=b
    batteries.sort()
    for(i in batteries.size-1 downTo 0){
      if (batteries[i]<=sum/n) return sum/n
      sum-=batteries[i]
      n-=1
    }
    return -1
  }
}