class Solution {
  fun minOperations(nums: IntArray, k: Int): Int {
      var ans = 0
      nums.forEach{
          if(it<k) ans++
      }
      return ans
  }
}