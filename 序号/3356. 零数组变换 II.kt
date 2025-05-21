class Solution {
  fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
       var l = -1
       val m = nums.size
       val n = queries.size
       var r = n+1
       fun check(k:Int):Boolean{
          val dif = IntArray(m+1)
          for(i in 0 until k){
              val (start,end,v) = queries[i]
              dif[start]+=v
              dif[end+1]-=v
          }
          var ps = 0
          for(i in 0 until m){
              ps+=dif[i]
              if(ps<nums[i]) return false
          }
          return true
       }
       while(l+1<r){
          val mid = (l+r)/2
          if(check(mid)){
              r=mid
          }else{
              l=mid
          }
       }
       return if(r==n+1) -1 else r
  }
}