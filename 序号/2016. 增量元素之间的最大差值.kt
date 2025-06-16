class Solution {
  fun maximumDifference(nums: IntArray): Int {
     var mxDif = -1
     var mn = nums[0]
     for(i in 1 until nums.size){
          if(nums[i]-mn>max(0,mxDif)) mxDif=nums[i]-mn
          if(nums[i]<mn) mn = nums[i]
     } 
     return mxDif
  }
}