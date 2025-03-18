class Solution {
  val max = 4e6.toInt()
  val isPrimes = BooleanArray(max+1){true}.apply {
      val l = mutableListOf<Int>()
      for (i in 2..max){
          if (this[i]) l.add(i)
          for (j in l){
              if (i*j>max) break
              this[i*j]=false
              if(i%j==0) break
          }
      }
      this[0]=false
      this[1]=false
  }

  fun diagonalPrime(nums: Array<IntArray>): Int {
      // 对角线总共2条
      val m = nums.size
      val n = nums[0].size
      var ans = 0
      var i = 0
      var j = 0
      while (i<m && j<n){
          if (isPrimes[nums[i][j]] && nums[i][j]>ans) ans = nums[i][j]
          ++i;++j
      }
      i=m-1
      j=0
      while(i>=0 && j<n){
          if (isPrimes[nums[i][j]] && nums[i][j]>ans) ans = nums[i][j]
          --i;++j
      }
      return ans
  }
}