/** 交换最少元素使两个数组升序,只能交换相同索引 */
fun minSwap(nums1: IntArray, nums2: IntArray): Int {
  // 题目必定满足条件，所以
  // 要么顺序位满足条件nums1[i]>nums1[i-1] && nums2[i]>nums2[i-1]
  // 要么交叉位满足条件nums1[i]>nums2[i-1] && nums2[i]>nums1[i-1]
  // 要么同时满足上面2个条件
  var a = 0;var b = 1 // a 上一个位置不换，总共的交换次数；b 上一个位置交换了，总共的交换次数
  
  for (i in 1 until nums1.size){
    var tmpa=Int.MAX_VALUE;var tmpb=Int.MAX_VALUE
    // 顺序位满足条件
    if(nums1[i]>nums1[i-1] && nums2[i]>nums2[i-1]){
      tmpa = a
      tmpb=b+1
    }
    if (nums1[i]>nums2[i-1] && nums2[i]>nums1[i-1] ){
      tmpa= minOf(tmpa,b)
      tmpb= minOf(tmpb,a+1)
    }
    a=tmpa;b=tmpb
  }
  return minOf(a,b)
}