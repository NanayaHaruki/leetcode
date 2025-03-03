class Solution {
  lateinit var s:String
  val mIps = mutableMapOf<Int,Int>()
  val mDfs = mutableMapOf<Int,Int>()
  fun ips(_l:Int,_r:Int):Int{
      val key = _l.shl(8).or(_r)
      if (mIps.contains(key)) return mIps[key]!!
      var (l,r)=_l to _r
      var cnt = 0
      while(l<r){
          if (s[l++]!=s[r--]) {
              ++cnt
          }
      }
      mIps[key]=cnt
      return cnt
  }
  fun dfs(r:Int,k:Int):Int{
      // 将0-r 分成k段，需要修改的最小字符
      // 最后一段最短1个字符，最长r+1-(k-1)
      if (k==1) return ips(0,r)
      if (k-1>r) return Int.MAX_VALUE
      val key = r.shl(8).or(k)
      if(mDfs.contains(key)) return mDfs[key]!!
      var ans=Int.MAX_VALUE
      for (l in k-1..r){
          val cnt = ips(l,r)
          if (cnt==0){
              ans = min(ans,dfs(l-1,k-1))
          }else{
              ans = min(ans,dfs(l-1,k-1)+cnt)
          }
      }
      mDfs[key]=ans
      return ans
  }
  fun palindromePartition(_s: String, k: Int): Int {
      // 可以修改字符，要求分隔成k段，每段都是回文
      s=_s
      return dfs(s.lastIndex,k)
  }
}