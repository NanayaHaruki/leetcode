class Solution {
  fun findMaximumNumber(_k: Long, x: Int): Long {
      // 数num的价值=二进制的1x 2x 3x。。位置上有多少个1
      var num = 0L
      var pre1 = 0L
      var k = _k
      
      for(i in 63-((k+1) shl x).countLeadingZeroBits()  downTo 0){
          val cnt = (pre1 shl i) + ((i.toLong()/ x) shl i shr 1)

          if(cnt > k) continue
          k-=cnt
          num = num or (1L shl i)
          if((i+1)%x==0)
              pre1++
//            println("$i ${(pre1 shl i)} ${(i/ x) shl i shr 1} $cnt $pre1 $num")
      }

      return num-1
  }
}