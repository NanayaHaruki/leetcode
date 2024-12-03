class Solution {
  fun checkTwoChessboards(coordinate1: String, coordinate2: String): Boolean {
      val diffR = abs(coordinate1[0]-coordinate2[0])
      val diffC = abs(coordinate1[1]-coordinate2[1])
      return (diffR+diffC)%2==0
  }
}