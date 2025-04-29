class Solution {
  fun countSubarrays(nums: IntArray, k: Int): Long {
      // 至少出现k次最大元素的子数组的数目
      // 统计最大元素出现的索引，如  2 5 8 ，k为2,则左端点1,2,右端点[5,n)都满足
      // 然后左右端点都往右跳，新符合条件的[oldL+1,l]为左端点，右端点为[newL,n)
      val t = nums.max()
      val ind = nums.indices.filter { nums[it]==t }
      if(ind.size<k) return 0
      val n = nums.size
      var ans = 1L*(ind[0]+1)*(n-ind[k-1])
      for (r in k until ind.size){
          ans+= 1L*(n - ind[r])*(ind[r-k+1]-ind[r-k])
      }
      return ans
  }
}