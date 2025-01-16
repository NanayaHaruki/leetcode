class Solution {
  fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
      var (l,r_or,bottom,ans)=IntArray(4)
      ans = Int.MAX_VALUE
      for(r in nums.indices){
          r_or = r_or or nums[r]
          while(l<=r && (nums[l] or r_or) >=k){
              // 符合条件
              ans = min(ans,r-l+1)
              l++
              if(l>bottom){ // 重新建栈
                  for(i in r-1 downTo l){
                      nums[i]=nums[i] or nums[i+1]
                  }
                  bottom=r
                  r_or=0
              }
              
          }
      }
      return if(ans==Int.MAX_VALUE) -1 else ans
  }
}

class Solution {
  fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
      for (i in 1 .. nums.size){
          for (j in i .. nums.size){
              var cur = 0
              for (k in j-i until j){
                  cur = cur or nums[k]
              }
              if (cur>=k) return i
          }
      }
      return -1
  }
}