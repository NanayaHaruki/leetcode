fun missingTwo(nums: IntArray): IntArray {
  // miss a and b,xor all numbers,result is a xor b
  // 随机选一位为1的，必定a和b 只有一个数这里为1，另一个数这里为0
  // 将数组分成二类，一类这一位是1，一类这一位是0。分别异或一次，就能拿到a和b
  
  // nums少了两个数
  // 计算1-N的异或
  var xor1 = 0
  for (i in 1..nums.size+2) xor1 = xor1 xor i
  // 再异或nums，即可得出少的两个数的异或 a xor b
  var xor2 = 0
  for (i in nums) xor2 = xor2 xor i
  
  val axb = xor1 xor xor2
  // 拿到最低一位1所在的位置，用这一位区分为两组数。其他的数
  val flag = axb and -axb
  var a = 0;var b = 0
  for (i in 1..nums.size+2){
    if (i and flag == flag) a=a xor i
    else b = b xor i
  }
  for (i in nums){
    if (i and flag == flag ) a = a xor i
    else b = b xor i
  }
  return intArrayOf(a,b)
}