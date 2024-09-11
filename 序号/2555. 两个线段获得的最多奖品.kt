class Solution {
  fun lowerBound(arr:IntArray,target:Int):Int{
      var l=-1
      var r = arr.size
      while(l+1<r){
          val m = (l+r)/2
          if(arr[m]<target){
              l=m
          }else if(arr[m]>target){
              r=m
          }else{
              r=m
          }
      }
      return r
  }
  fun maximizeWin(prizePositions: IntArray, k: Int): Int {
      val n = prizePositions.size
      val f = IntArray(n+1) // f[i] 前i个数能获得的最大奖品数
      var ans = 0
      for(i in prizePositions.indices){
          // i为右端点，i-k为左端点
          val j = lowerBound(prizePositions,prizePositions[i]-k)
          ans = max(ans,i-j+1+f[j])  // i-j+1 表示当前这一段能拿多少奖品，f[j]表示前j个，也就是不包括j，j前面的范围能拿的最多奖品
          f[i+1]=max(f[i],i-j+1)
      }
      return ans
  }
}