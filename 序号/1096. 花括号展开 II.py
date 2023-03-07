class Solution {
  fun braceExpansionII(expression: String): List<String> {
    val tree = TreeSet<String>()
    fun dfs(e:String){
      val j  = e.indexOf('}')
      if (j==-1){
        tree.add(e)
        return
      }
      val i = e.lastIndexOf('{',j-1)
      val left = e.substring(0,i)
      val right = e.substring(j+1)
      for(c in e.substring(i+1,j).split(',')){
        dfs(left+c+right)
      }
    }
    dfs(expression)
    return tree.toList()
  }
}