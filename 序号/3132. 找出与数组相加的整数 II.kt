// 只需要判断前3个即可，时间复杂度 N
class Solution {
  fun isSub(nums1:IntArray,nums2:IntArray,start:Int):Boolean{
      var j = 0
      val diff = nums2[0]-nums1[start]
      for(i in start until nums1.size){
          if(nums1[i]+diff==nums2[j]){
              j++
              if(j==nums2.size){
                  return true
              }
          }
      }
      return false
  }
  fun minimumAddedInteger(nums1: IntArray, nums2: IntArray): Int {
      nums1.sort()
      nums2.sort()
      // 删掉2个，则前3个必定保留至少一个，后面的num2是nums1的子序列
      for(start in 2 downTo 1){
          if(isSub(nums1,nums2,start)){
              return nums2[0]-nums1[start]
          }
      }
      return nums2[0]-nums1[0]
  }
}

// 暴力 ，枚举删掉所有2个数字的可能性，时间复杂度 N^2
class Solution {
  fun getX(nums1:IntArray,nums2:IntArray,i:Int,j:Int):Int{
      var a = 0
      var b = 0
      var diff = 2000
      while (a<nums1.size && b<nums2.size){
          if (a==i || a==j){
              a++
              continue
          }
          if (diff==2000){
              diff = nums2[b++]-nums1[a++]
          }else{
              val curDiff = nums2[b]-nums1[a]
              if (curDiff==diff){
                  a++;b++
              }else{
                  return 2000
              }
          }
      }
      return diff
  }
  fun minimumAddedInteger(nums1: IntArray, nums2: IntArray): Int {
      var (p1,p2)= arrayOf(0,0)
      val n = nums1.size
      var minDiff = 2000
      nums1.sort()
      nums2.sort()
      for(i in 0..n-2){
          for(j in i+1..<n){
              // 去掉这索引为i，j的两个数
              val diff = getX(nums1,nums2,i,j)
              if (diff <minDiff) {
                  minDiff=diff
              }

          }
      }
      return minDiff
  }
}