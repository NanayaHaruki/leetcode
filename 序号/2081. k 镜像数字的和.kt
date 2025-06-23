class Solution {
  fun nextDec(i:Long):Long{
      // 如果全是9,得增加位数。
      // 如果是奇数，中间的+1 ; 如果是偶数，靠近中间的2位+1
      val s = StringBuilder().append(i)
      if(s.all { it =='9' }){
          return i+2
      }
      val n = s.length
      var l = 0
      var r = 0
      if(n.and(1)==1){
          if(s[n/2]!='9') {
              s[n / 2] = s[n / 2] + 1
              return s.toString().toLong()
          }else {
              l = n / 2 - 1
              r = n / 2 + 1
              s[n/2]='0'
          }
      }else{
          l = n/2-1
          r = n/2
      }
      while (s[l]=='9'){ // 不可能都是9,最开始就判断过了
          s[l--]='0'
          s[r++]='0'
      }
      s[l]++
      s[r]++

      return s.toString().toLong()
  }
  fun isMirror(_i: Long, k:Int): Boolean{
      val sb = StringBuilder()
      var i = _i
      while (i>0){
          sb.append(i%k)
          i/=k
      }
      var l = 0
      var r = sb.lastIndex
      while(l<r){
          if(sb[l]==sb[r]){
              l++
              r--
          }else{
              return false
          }
      }
      return true
  }
  fun kMirror(k: Int, n: Int): Long {
      // 十进制和k进制都镜像的数，找最小的n个数之和
      var ans = 0L
      var left = n
      var i = 1L
      while (left>0){
          if(isMirror(i,k)){
              println(i)
              ans+=i
              left--
          }
          i = nextDec(i)
      }
      return ans
  }
}