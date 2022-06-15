fun smallestDistancePair(nums: IntArray, k: Int): Int {
  // 从0-最大差值二分，双指针计算小于mid的数对数量i，
  // i>k，说明当前差值大了，二分右边界缩小；i<k,当前差值小了，左边界内缩；i==k，此时差值也是大了，比如差值为1 3 7，找第3个大的，二分到4 5 6 7 都是第3个大。所以需要收缩右边界
  nums.sort()
  var l = 0;var  r = nums.last()-nums.first()
  while(l<=r){
    val m = l+((r-l) shr 1)
    print(listOf(l,r,m))
    if(check(nums,m)>=k) r=m-1
    else l=m+1
  }
  return l
}

fun check(nums:IntArray,m:Int):Int{
  var ans = 0
  for (i in 1 until nums.size){
    for (j in 0 until i){
      if (nums[i]-nums[j]<=m) {
        ans+= i-j
        break
      }
    }
  }
  println(ans)
  return ans
}