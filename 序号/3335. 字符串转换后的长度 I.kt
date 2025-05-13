class Solution {
    
  fun lengthAfterTransformations(s: String, t: Int): Int {
      // a 变化25次到z 26次变ab 再24次变zab 25次变abbc 
      val mod = 1_000_000_007
      val mem = Array(26){IntArray(100001)}
      fun dfs(c:Char,left:Int):Int{
          val newLeft = left-('z'-c)
          if(newLeft<=0) return 1
          if(mem[c-'a'][left]>0) return mem[c-'a'][left]
          return ((dfs('a',newLeft-1)+dfs('b',newLeft-1)) % mod).apply{mem[c-'a'][left]=this}
      }
      var ans = 0
      for(c in s){
          ans = (ans + dfs(c,t)) % mod
      }
      return ans.toInt()
  }
}