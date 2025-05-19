class Solution {
  fun triangleType(nums: IntArray): String {
      nums.sort()
      val (a,b,c) = nums
      return when{
          a+b<=c -> "none"
          a==c -> "equilateral"
          a==b || b==c -> "isosceles"
          else -> "scalene"
      }
  }
}