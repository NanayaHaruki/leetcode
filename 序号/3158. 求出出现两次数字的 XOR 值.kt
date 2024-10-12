class Solution {
  fun duplicateNumbersXOR(nums: IntArray): Int {
      var vis = 0L
      var ans = 0
      for(x in nums){
          if(((vis shr x) and 1) == 1L){ // 遇到过，那就出现2次了，加入答案
              ans = ans xor x
          }else{
              vis = vis xor (1L shl x)
          }
      }
      return ans
  }
}