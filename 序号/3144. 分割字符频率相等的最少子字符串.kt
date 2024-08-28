class Solution {
  fun minimumSubstringsInPartition(s: String): Int {
      // 找到一个平衡字符串后，记录端点，后面再继续找
      val cs = s.toCharArray()
      val n = cs.size
      var ans = 1000
      val mem = mutableMapOf<Int,Int>()
      fun dfs(start:Int):Int{
          if(start == n) return 0
          if(mem.contains(start)) return mem[start]!!
          val d = IntArray(26)
          var ans = 1000
          for(i in start until n){
              d[cs[i]-'a']+=1
              var m = 0
              var valid = true
              for(j in 0 until 26){
                  if(d[j]!=0){
                      if(m==0) m = d[j]
                      else{
                          if(m!=d[j]){
                              valid = false
                              break
                          }
                      }
                  }
              }
              if(valid){
                  ans = min(ans, 1+dfs(i+1))
              }else{
                  // 加上i之后不合法就继续往后找
              }

          }
          mem[start]=ans
          return ans
      }
      return dfs(0)
  }
}