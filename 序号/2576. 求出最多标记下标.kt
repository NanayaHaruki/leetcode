class Solution {
  fun lower(nums:IntArray,t:Int,start:Int,end:Int):Int{
      var l = start-1
      var r=end+1
      while(l+1<r){
          val m = (l+r)/2
          if(nums[m]>=t){
              r=m
          }else{
              l=m
          }
      }
      return r
  }
  fun maxNumOfMarkedIndices(nums: IntArray): Int {
      nums.sort()
      val n = nums.size
      var l = 0
      var r = (n+1)/2
      for(i in r until n){
          if(nums[l]*2<=nums[i]) l++
      }
      return l*2
  }
}