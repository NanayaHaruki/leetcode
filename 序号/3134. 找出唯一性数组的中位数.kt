class Solution {
  fun medianOfUniquenessArray(nums: IntArray): Int {
      val n = nums.size
      val target = (n.toLong()*(n+1)/2+1)/2
      var (l,r) = intArrayOf(0,n)
      // 子数组总共有 1，2，3.。。n个
      // distint数组的长度为 （1+n）*n/2，形式为[1,1,1,2,2,2,2,3,3]
      // 找到某个数的右边界超过一半了就是答案
      // 问题变成求小于mid的子数组个数

      // 用滑动数组，每加入一个新的元素，如果元素个数超了，就弹出老的元素，直到符合要求，
      // 此时数组中是满足要求的，以新元素为右端点，滑动数组内其他老元素都可以作为子数组的左端点，总共有r-l+1个满足要求的子数组

      fun check(mid:Int):Boolean{
          val d = mutableMapOf<Int,Int>()
          var ll=0
          var cnt = 0L
          for (rr in nums.indices){
              val x = nums[rr]
              d[x] = d.getOrDefault(x,0)+1
              while (d.size>mid){
                  val nv = d[nums[ll]]!!-1
                  if(nv==0) d.remove(nums[ll])
                  else d[nums[ll]]=nv
                  ll++
              }
              cnt=cnt + rr-ll+1
              if (cnt>=target) return true
          }
          return false
      }
      while(l+1<r){
          val mid = (l+r)/2
          if (check(mid)){
              r=mid
          }else{
              l=mid
          }
      }
      return r
  }
}