class Solution {
  fun smallestRangeII(nums: IntArray, k: Int): Int {
      // [0,i]变大，[i+1,n-1]变小
      nums.sort()
      var ans = nums.last()-nums.first()
      for(i in 0 .. nums.size-2){
          val mx = max(nums[i]+k,nums.last()-k)
          val mn = min(nums[0]+k,nums[i+1]-k)
          ans = min(ans,mx-mn)
      }
      return ans
  }
}