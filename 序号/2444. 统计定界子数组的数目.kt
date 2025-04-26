class Solution {
  fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
      // 从左往右遍历，那以右端点为终点，判断左端点有多少个符合要求的
      // 如果以i为右端点，上一个不能进子数组的点j肯定不会在[minIndex,maxIndex]中，j更小
      // 合法左端点为i+1，合法总数为 min(minIndex,maxIndex)-j
      var ans = 0L
      var minIndex = -1
      var maxIndex = -1
      var invalidIndex = -1
      nums.forEachIndexed{i,x->
          if(x==maxK) maxIndex=i
          if(x==minK) minIndex=i
          if(x in minK..maxK){
             // 可以当右端点，统计答案
              ans+=max(0,min(maxIndex,minIndex)-invalidIndex)
          }else{
              invalidIndex=i
          } 
          
      }
      return ans
  }
}