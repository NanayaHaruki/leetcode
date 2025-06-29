class Solution {
  fun numSubseq(nums: IntArray, target: Int): Int {
      nums.sort()
      val n = nums.size
      var l = 0
      var r = n-1
      var ans = 0
      while (l<=r){
          if(nums[l]+nums[r]<=target){ // 满足要求，l必选，[l+1，r]选0个C(N,0) 选1个c(n,1)...组合和公式为2^n
              ans= (ans + pow2[r-l])%mod
              l++
          }else{
              r--
          }
      }
      return ans
  }
//    fun numSubseq(nums: IntArray, target: Int): Int {
//        nums.sort()
//        val n = nums.size
//
//        fun calc(i:Int):Int{
//            var l = i-1
//            var r = n
//            while(l+1<r){
//                val mid = (l+r)/2
//                if(nums[i]+nums[mid]<=target) l=mid
//                else r = mid
//            }
//            return pow2[l-i]
//        }
//        var ans = 0
//
//        for(i in 0 until n){
//            if(2*nums[i]>target) break
//            ans = (ans + calc(i))%mod
//        }
//        return ans
//    }
  companion object{
      const val mod = 1_000_000_007
      val pow2 = IntArray(100000).apply {
          set(0,1)
          for (i in 1 until size){
              set(i,get(i-1)*2%mod)
          }
      }

  }
}