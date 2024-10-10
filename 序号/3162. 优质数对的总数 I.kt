class Solution {
  fun numberOfPairs(nums1: IntArray, nums2: IntArray, k: Int): Int {
      val m = nums1.size
      val n = nums2.size
      var cnt = 0
      for(i in 0 until m){
          for(j in 0 until n){
              if(nums1[i]%(k*nums2[j])==0) cnt++
          }
      }
      return cnt
  }
}