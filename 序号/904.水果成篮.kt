fun totalFruit(fruits: IntArray): Int {
  var ans =0
  var f1 = -1;var f2=-1 // 两种水果
  var indexOfFirst1 = -1;var indexOfLast1 = -1 // 第一类水果的第一次出现和最后一次出现位置
  var indexOfFirst2 = -1;var indexOfLast2=-1   // 第二类水果。。。
  for (i in fruits.indices){
    val f = fruits[i]
    if (f==f1){
      indexOfLast1=i
      continue
    }
    if (f==f2){
      indexOfLast2=i
      continue
    }
    if (f1==-1) {
      f1=f
      indexOfFirst1=i
      indexOfLast1=i
    }
    else if(f2==-1){
      f2=f
      indexOfFirst2=i
      indexOfLast2=i
    }
    else{
      // 有不同的了,判断长度，更新索引和水果类型
      ans= maxOf(ans,i-indexOfFirst1)
      
      // 比对两种水果最后出现的位置，找出靠左边的那个扔掉
      val min = minOf(indexOfLast1,indexOfLast2)
      if (min==indexOfLast1){
        indexOfFirst1=min+1 // 如果1 在左边，左边界更新成后一位。右边界为2的右边界
        indexOfLast1=indexOfLast2
        f1=f2
      }else{
        indexOfFirst1=min+1 // 如果2在左边，1的左边界更新后一位，右边界还是自己的右边界
      }
      
      indexOfFirst2=i
      indexOfLast2=indexOfFirst2
      f2=fruits[indexOfFirst2]
    }
  }
  // 再次更新下ans
  return maxOf(ans,fruits.size-indexOfFirst1)
}