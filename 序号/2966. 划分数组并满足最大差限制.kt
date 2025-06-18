class Solution {
  fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
      val n = nums.size
      if(n%3!=0) return emptyArray()
      nums.sort()
      val ans = Array(n/3){ IntArray(3) }
      for(i in 0 until n step 3){
          if(nums[i+2]-nums[i]>k)
              return emptyArray()
          for(j in 0..2) 
              ans[i/3][j]=nums[i+j]
      }
      return ans
  }
}