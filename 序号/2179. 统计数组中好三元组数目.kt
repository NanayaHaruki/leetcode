class Solution {
  class BIT(val  n:Int){
    val t = IntArray(n+1)

    fun lowbit(x:Int) = x and  -x

    fun update(idx:Int,value:Int){
      var i = idx
      while(i<=n){
        t[i]+=value
        i+=lowbit(i)
      }
    }

    fun query(idx:Int):Int{
      if(idx<0) return 0
      var i = idx
      var ans = 0
      while(i>0){
        ans+=t[i]
        i-=lowbit(i)
      }
      return ans
    }
  }
  fun goodTriplets(nums1: IntArray, nums2: IntArray): Long {
    // 在两个数组中找出互不相同的三个数，它们在两个数组中出现的位置关系一致，返回这样三元组的数量
    // 将nums1中数字用索引替换掉，将nums2对应替换。则对于nums2[i]来说，前面有几个比nums2[i]小的 * 后面有几个比nums2[i]大的就是当前i为三元组中间值的个数，统计总个数即可
    val n = nums1.size
    val map = IntArray(n)
    for (i in 0 until n){
      map[nums1[i]]=i
    }
    for(i in 0 until n){
      nums2[i]=map[nums2[i]]
    }
    val bit = BIT(n)
    var ans = 0L
    for(i in 0 until n){
      val lower = bit.query(nums2[i]) // nums2[i]左边 比它小的数有less个
      val higher = n -1- nums2[i] - (i - lower)  // 总共比nums2[i]大的数有 n-i 个，nums2[i]左边有lower个比它小的，也就有i-lower个比它大的
      ans=ans+ lower.toLong()*higher
    //   println("$lower $higher $ans")
      bit.update(nums2[i]+1,1)
    }
    return ans
  }
}