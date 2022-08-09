class Solution {
  fun minStartValue(nums: IntArray): Int {
    // 前缀和找最小值，大于0，则返回1，小于0，返回-pre+1
    var sum = 0;var min = Int.MAX_VALUE
    
    for(i in nums){
      sum+=i
      min = minOf(min,sum)
    }
    if(min>0) return 1
    return 1-min
  }
}