class Solution {
  fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
      var (rightOr,ans,l,bottom) = IntArray(4)
      ans = 0x3f3f3f3f
      for(r in nums.indices){
          rightOr = rightOr or nums[r]
          while(l<=r && nums[l].or(rightOr)>=k){
              ans = min(ans,r-l+1)
              l++
              if(l>bottom){
                  for(i in r-1 downTo l){
                      nums[i] = nums[i] or nums[i+1]
                  }
                  bottom=r
                  rightOr=0
              }
          }
      }
      return if(ans==0x3f3f3f3f) -1 else ans
  }
}