class Solution {
  fun check(ps:Array<IntArray>,a:Int,b:Int,k:Int):Boolean{
      for(i in 0..4){
          if(ps[b+1][i]-ps[a][i]==0) return false
      }
      return ps[b+1][5]-ps[a][5]==k
  }
  val d = mutableMapOf('a' to 0,'e' to 1,'i' to 2,'o' to 3,'u' to 4)
  fun countOfSubstrings(word: String, k: Int): Int {
      // 想了半天，想不出怎么滑。 
      // 右端点满足要求了，左端点也不能滑，因为右边继续加元音也是可以的，左边一滑就漏掉了
      // 直接暴力了
      val n = word.length

      // 前缀和计算任意区间内元音辅音个数
      val ps = Array(n+1){IntArray(6)}
      for(i in 0 until n){
          for(j in 0..5){
              if(j==d.getOrDefault(word[i],5)) ps[i+1][j]=ps[i][j]+1
              else ps[i+1][j]=ps[i][j]
          }
      }

      var ans = 0
      for(i in 0 until n){
          for(j in i+4+k until n){
              if(check(ps,i,j,k)) ++ans
          }
      }
      return ans
  }
}