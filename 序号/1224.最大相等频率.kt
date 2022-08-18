fun maxEqualFreq(nums: IntArray): Int {
  // 取最长前缀的长度。前缀满足删掉一个数后，其他数字出现次数相同
  val a=mutableMapOf<Int,Int>() // key为数字，value为次数
  val b=mutableMapOf<Int,Int>() // key为次数，value为出现该次数的数字个数
  var maxCnt=0
  var maxLenPrefix = 0
  for(i in nums.indices){
    val cnt =a.getOrDefault(nums[i],0)+1
    a[nums[i]]=cnt
    b[cnt]=b.getOrDefault(cnt,0)+1
    if(cnt>1) b[cnt-1]=b.getOrDefault(cnt-1,0)-1
    maxCnt=maxOf(maxCnt,cnt)
    if(maxCnt==1 // 最多出现次数为1，随便删一个
      ||(b.getOrDefault(maxCnt,0)==1 && b.getOrDefault(maxCnt-1,0)*(maxCnt-1)==i+1-maxCnt) // 有一个数出现次数为最多。其他数出现次数比它少1个，将这个出现次数最多的数删掉一个
      ||(b.getOrDefault(maxCnt,0)*maxCnt==i )) // 只有一个数出现了1次
      maxLenPrefix=i+1
  }
  return maxLenPrefix
}