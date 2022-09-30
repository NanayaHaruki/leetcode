// 执行用时：240 ms, 在所有 Kotlin 提交中击败了75.00% 的用户
// 内存消耗：37 MB, 在所有 Kotlin 提交中击败了87.50% 的用户
// 通过测试用例：32 / 32
fun singleNumber(nums: IntArray): Int {
  // 可以设计一种逻辑，使数字出现 3 次时，该逻辑的结果为 0（即只有 0，1，2 三种状态）
  // 其实就是一个 三进制
  // 一位二进制数只能存储 0 和 1 两种状态，所以我们需要用到两位二进制
  // 设两位二进制数的高位为 A，低位为 B。C 是输入变量
  // 表示的三种情况为 ： 0次：00(A=0,B=0), 1次：01(A=0,B=1), 2次：10(A=1,B=0)
  // 注：11(A=1,B=1) 为无效输入
  
  // 画出关于 A 的卡诺图（AB为11的结果是不重要的，用 x 表示）：
  //  AB\C |  0  |  1
  //  =================
  //    00 |  0  |  0
  //    01 |  0  |  1        ====> 得到 A = BC + AC'
  //    11 |  x  |  x
  //    10 |  1  |  0
  
  //  画出关于 B 的卡诺图
  //  AB\C |  0  |  1
  //  =================
  //    00 |  0  |  1
  //    01 |  1  |  0        ====> 得到 B = BC' + A'B'C
  //    11 |  x  |  x
  //    10 |  0  |  0
  
  // 很明显啊，我们需要的就是只出现一次的情况 01（A=0，B=1），即 B 的结果
  var A = 0
  var B = 0
  for (C in nums) {
    val tmp = A
    A = B and C or (A and C.inv())
    B = B and C.inv() or (tmp.inv() and B.inv() and C)
  }
  return B
}


// 执行用时：308 ms, 在所有 Kotlin 提交中击败了12.50% 的用户
// 内存消耗：37.6 MB, 在所有 Kotlin 提交中击败了50.00% 的用户
// 通过测试用例：32 / 32
fun singleNumber(nums: IntArray): Int {
  // int总共32位，只有一个数出现1次，其他数出现3次。
  // 出现3次的数，他们的每1bit上1出现次数都是3。其他出现3次的数又会让这一位的1次数+3
  // 统计出每一位1的次数，模3就可以去除出现3次的数，剩下的就是只出现1次的答案了
  
  val cntArr = IntArray(32)
  var f = 1
  for(i in nums){
    f=1
    for(j in 0 until 31){
      if(i and f == f) cntArr[j]++
      f = f shl 1
    }
  }
  f = 1
  var ans = 0
  for(idx in cntArr.indices){
    if(cntArr[idx]%3==1){
      ans+=f
    }
    f*=2
  }
  return ans
}