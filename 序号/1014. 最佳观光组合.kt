class Solution {
  fun maxScoreSightseeingPair(values: IntArray): Int {
      var i = values[0]
      var mx = 0
      for (idx in 1 until values.size){
          val j = values[idx]-idx
          if(i+j>mx) mx = i+j
          if(values[idx]+idx>i) i=values[idx]+idx
      }
      return mx
  }
}