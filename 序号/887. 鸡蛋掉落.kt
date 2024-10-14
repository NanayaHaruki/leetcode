class Solution {
  val m = mutableMapOf<Int,Int>()
  fun calc(eggCnt:Int,tryCnt:Int):Int{
      // 只有1个蛋，只能试2层
      if(eggCnt==1 || tryCnt ==1 ) return tryCnt+1
      val key = (tryCnt shl 8) or eggCnt
      if(m.contains(key)) return m[key]!!
      val ans = calc(eggCnt-1,tryCnt-1)+calc(eggCnt,tryCnt-1)
      m[key]=ans
      return ans
  }
  fun superEggDrop(k: Int, n: Int): Int {
      var tryCnt=1
      while(calc(k,tryCnt)<n+1) tryCnt++
      return tryCnt
  }
}