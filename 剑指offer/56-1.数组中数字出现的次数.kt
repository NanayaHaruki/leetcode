fun singleNumbers(nums: IntArray): IntArray {
  var x = 0
  for(n in nums) x = x xor n
  // x 为 出现一次的两个数字的异或，求出这个值的最低一个为1的bit，
  // 两个数字必然一个数在这bit为0，另一个数为1
  // 利用这个标记将nums分成两组，一组这bit为1，一组为0
  // 两组继续异或，出现两次的抵消掉，留下来的就是答案的两个数
  val flag = x and -x
  var a = 0;var b = 0
  for(n in nums){
    if(n and flag == flag)
      a = a xor n
    else
      b = b xor n
  }
  return intArrayOf(a,b)
  
}