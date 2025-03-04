class Solution {
  lateinit var s:String
  val mIps = mutableMapOf<Int,Boolean>()
  val mDfs = mutableMapOf<Int,Boolean>()

  fun ips(_l:Int,_r:Int):Boolean{
      val key = _l.shl(11).or(_r)
      if (mIps.contains(key)) return mIps[key]!!
      var (l,r)=_l to _r
      while(l<r){
          if (s[l++]!=s[r--]) {
              return false
          }
      }
      mIps[key]=true
      return true
  }
  fun dfs(r:Int,k:Int):Boolean{
      // 将0-r 分成k段，
      if (k==1) return ips(0,r)
      val key = r.shl(8).or(k)
      if(mDfs.contains(key)) return mDfs[key]!!
      var ans=false
      for (l in k-1..r){
          if(ips(l,r) && dfs(l-1,k-1)){
              ans = true
              break
          }
      }
      mDfs[key]=ans
      return ans
  }
  fun checkPartitioning(_s: String): Boolean {
      // 能否分成3段
      s=_s
      return dfs(s.lastIndex,3)
  }
}