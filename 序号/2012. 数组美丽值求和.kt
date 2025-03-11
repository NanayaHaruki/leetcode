class Solution {
  fun lower(arr:List<Int>,t:Int):Int{
      var l = -1
      var r = arr.size
      while(l+1<r){
          val m = (l+r)/2
          if(arr[m]>=t){
              r=m
          }else{
              l=m
          }
      }
      return r
  }
  fun higher(arr:List<Int>,t:Int):Int{
      var l = -1
      var r = arr.size
      while(l+1<r){
          val m = (l+r)/2
          if(arr[m]>t){
              r=m
          }else{
              l=m
          }
      }
      return arr.size-l-1
  }
  fun sumOfBeauties(nums: IntArray): Int {
      // 所有前面的都小，后面的都大，值为2
      // 只有两边相邻的满足，值为1
      // 针对位置i，我需要知道[0,i-1]最大的数，以及[i+1,n-1]最小的数
      val n = nums.size
      var ans = 0
      val left = IntArray(n)
      val right = IntArray(n){100001}
      for(i in 1 .. n-2){
          left[i]=max(left[i-1],nums[i-1])
      }
      for(i in n-2 downTo 1){
          right[i]=min(right[i+1],nums[i+1])
      }
      for(i in 1 .. n-2){
          if(left[i]<nums[i] && right[i]>nums[i]){
              ans+=2
          }else if(nums[i-1]<nums[i] && nums[i]<nums[i+1]){
              ans+=1
          }
      }
      return ans
  }
}