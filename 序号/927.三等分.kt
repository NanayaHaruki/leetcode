/** 数组分成三部分，让每部分一样；数组只有0和1 */
fun threeEqualParts(arr: IntArray): IntArray {
  val sum = arr.sum()
  if(sum==0) return intArrayOf(0,2)
  if (sum%3!=0) return intArrayOf(-1,-1)
  // 可以被3整除，找到1的分割点
  // 前导0不用管，后置0就是第3堆的1后面的0，第3堆的1到数组最后就是有效位数。
  // 从每个分割点开头比对是否一致
  val splitIndex = mutableListOf<Int>()
  val amountOfOne = sum/3
  
  var cnt = 0
  for (i in arr.indices){
    if (arr[i]==1) {
      cnt++
      if (amountOfOne==1 || cnt%amountOfOne==1) splitIndex.add(i)
    }
  }
  
  val len = arr.size-splitIndex[2]
  var i=0
  var p1 = splitIndex[0]
  var p2 = splitIndex[1]
  var p3 = splitIndex[2]
  while (i<len){
    val a = arr[p1]
    val b = arr[p2]
    val c = arr[p3]
    if(a==b && b==c){
      p1++;p2++;p3++;i++
    }else{
      return intArrayOf(-1,-1)
    }
  }
  // 分割点是第一堆的最后一个 和 第三堆的第一个
  return intArrayOf(splitIndex[0]+len-1,splitIndex[1]+len)
}