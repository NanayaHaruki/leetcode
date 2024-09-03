class Solution {
  fun maxStrength(nums: IntArray): Long {
      val n= nums.size
      if(n==1) return nums[0].toLong()
      nums.sort()
      var i = n-1
      var ans = 0L
      while(i>=0 && nums[i]>0){
          if(ans==0L) ans = nums[i].toLong()
          else ans*=nums[i]
          i--     
      }
      while(i>=0 && nums[i]==0) i--
      for(i in 1..i step 2){
          if(ans==0L) ans = 1L*nums[i-1]*nums[i]
          else ans*=nums[i]*nums[i-1]
      }
      return ans
  }
}