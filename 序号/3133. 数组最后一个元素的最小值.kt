class Solution {
  fun minEnd(n: Int, x: Int): Long {
      // 只要有0，与完就是0，所以nums中所有数都必须包含x的设置位
      // x的二进制中为0的位，nums的数中至少有一个数该位置为0
      // x的0位有i个，可以放2^i个数，如果n<=2^i,就可以得到答案
      // 如果不够放，在x的最高位1的前面补1后，后面再在有0的位补上

      val spaces = mutableListOf<Int>()
      for(i in 0..31){
          if(x.shr(i).and(1) == 0){
              spaces.add(i)
          }
      }
      val needSpace = ceil(log2(n+1.0)).toInt()
      for(i in 0 until needSpace-spaces.size){
          spaces.add(spaces.last()+1)
      }
      var ans = x.toLong()
      var t = n-1
      for(i in 0..31){
          if(t.shr(i).and(1)==1){
              ans = ans or (1L shl spaces[i])
          }
      }
      return ans
  }
}