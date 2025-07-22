class Solution {
  fun maximumUniqueSubarray(nums: IntArray): Int {
      // 删除元素和最大的子数组，数组元素不能重复
      // 右端点尽量右移，除非右边元素在数组内已经有了;移动左端点，直到将有的元素移出
      val has = BooleanArray(nums.max()+1)
      var l = 0
      var ans = 0
      var sum = 0
      for(x in nums){
          while(has[x]){ // 把x加进子数组之前，先去掉前面的相同元素x
              sum-=nums[l]
              has[nums[l]]=false
              ++l
          }
          has[x]=true
          sum+=x
          ans = sum.coerceAtLeast(ans)
      }
      return ans
  }
}