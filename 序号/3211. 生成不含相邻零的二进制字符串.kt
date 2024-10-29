class Solution {
  
  fun validStrings(n: Int): List<String> {
      val ans = mutableListOf<String>()
      
      fun dfs(s:String){
          if (s.length==n) {
              ans.add(s)
              return 
          }
          if(s.last()=='0') dfs(s+'1')
          else{
              dfs(s+'0')
              dfs(s+'1')
          }
      }
      dfs("0")
      dfs("1")
      return ans
  }
}