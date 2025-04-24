class Solution {
  fun countCompleteSubarrays(nums: IntArray): Int {
      val distinctCnt = nums.toSet().size
      val st = mutableMapOf<Int,Int>()
      var ans = 0
      val n = nums.size
      var r = 0
      for(l in 0 .. n-distinctCnt){
          while(r<n && st.size<distinctCnt){
              st.merge(nums[r++],1,Int::plus)
          }
          if(st.size==distinctCnt) ans+=n-r+1
          st.computeIfPresent(nums[l]){_,v->if(v==1) null else v-1}
      }
      return ans
  }
}