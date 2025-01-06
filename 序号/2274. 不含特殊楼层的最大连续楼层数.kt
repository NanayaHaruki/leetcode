class Solution {
  fun maxConsecutive(bottom: Int, top: Int, special: IntArray): Int {
      special.sort()
      var mx = max(special[0]-bottom,top-special.last())
      for(i in 1 until special.size){
          mx = max(mx,special[i]-special[i-1]-1)
      }
      return mx
  }
}