class Solution {
  lateinit var f:IntArray
  fun find(x:Int):Int{
      if(f[x]!=x){
          f[x]=find(f[x])
      }
      return f[x]
  }
  fun connect(i:Int,j:Int):Boolean{
      val fi = find(i)
      val fj = find(j)
      if(fi==fj) return true
      f[fi]=f[fj]
      return false
  }
  fun findRedundantConnection(edges: Array<IntArray>): IntArray {
      val n = edges.size
      f=IntArray(n+1)
      for(i in 1..n){
          f[i]=i
      }
      for(e in edges){
          
          if(connect(e[0],e[1])) return e 
      }
      return IntArray(0)
  }
}