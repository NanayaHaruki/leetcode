class Solution {
  fun countBalls(lowLimit: Int, highLimit: Int): Int {
    // 方法二 数位dp
    val high = highLimit.toString()
    val n = high.length
    val low = lowLimit.toString().padStart(n,'0')
    /**
     * @param i 当前位是几
     * @param lowLimit 是否受下限限制，比如下限是123，上限456。第1位必须取1，不能取0
     * @param highLimit 是否受上限限制，上限456，第1位<4时，第2位随便。第1位为4，第2位受限只能到5
     * @param left 还可以装多少数字的和
     * */
    val mem = IntArray(1 shl 9){-1} // i有10种可能，占4位，isLowLimit和isHighLimit各占1位，left占6位因为1e5各位相加可能有46种情况
    fun dfs(i:Int,isLowLimit: Boolean,isHighLimit: Boolean,left:Int):Int{
      if(left<0) return 0
      if (i==n) return if (left==0) 1 else 0
      val k = left.shl(6)
        .or(i.shl(2))
        .or((if(isLowLimit) 1 else 0) shl 1)
        .or(if(isHighLimit) 1 else 0)
      if (mem[k]!=-1) return mem[k]
      val lo = if (isLowLimit) low[i]-'0' else 0
      val hi = if (isHighLimit) high[i]-'0' else 9
      var ans = 0
      for (j in lo .. hi){
        ans+=dfs(i+1,isLowLimit && j==lo,isHighLimit && j==hi,left-j)
      }
      mem[k]=ans
      return ans
    }
    var ans = 0
    for (left in 1..high[0].digitToInt()+(n-1)*9){
      ans = max(ans,dfs(0,true,true,left))
    }
    return ans


    // 方法一 暴力 最多1e5，46种可能性. 时间：n*len(highLimit)
//    val a = IntArray(46)
//    for (i in lowLimit..highLimit){
//      var j = i
//      var k = 0
//      while(j>0){
//        k += j%10
//        j/=10
//      }
//      a[k]++
//    }
//    return a.max()
  }
}