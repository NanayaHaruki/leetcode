class Solution {
  fun edgeScore(edges: IntArray): Int {
      val f = LongArray(edges.size)
      edges.forEachIndexed {index,i ->
          f[i]+=index.toLong()
      }
      var mx = 0L
      var idx = 0
      f.forEachIndexed { index, i ->
          if (i>mx) {
              idx=index
              mx=i
          }
      }
      return idx
  }
}