class Solution {
  fun countCompleteDayPairs(hours: IntArray): Long {
      val mods = IntArray(24)
      var ans = 0L
      for(x in hours){
          ans+=mods[(24-x%24)%24]
          mods[x%24]++
      }
      return ans
  }
}