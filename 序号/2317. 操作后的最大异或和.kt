class Solution {
  fun maximumXOR(nums: IntArray): Int {
      // nums[i] 为 nums[i] AND (nums[i] XOR x) 
      // 替换操作意味着可以将nums[i]的1变成0，但没办法让0变成1
      // 为了让nums 异或最大，就要保留每个1
      for(i in 1 until nums.size){
        nums[i]= nums[i] or nums[i-1]
      }
      return nums[nums.size-1]
  }
}