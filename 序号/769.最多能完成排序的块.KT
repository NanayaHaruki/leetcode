fun maxChunksToSorted(arr: IntArray): Int {
  // arr为0-n-1的数，所有数不重复且连续，排序完成的情况下应当是值=角标的。
  // 乱序情况下，前i个数中最大为j，则j=i，才能排序后为升序。遍历数组统计最大值，当值与角标相同是答案自增即可。
  var ans = 0;
  var max = 0
  for(i in arr.indices){
    max= maxOf(max,arr[i])
    if(max==i) ans++
  }
  return ans
}

/** 将数组分成几块，每块分别排序，使结果与愿数组升序排序结果相同，len=n arr[i]=[0,n) */
fun maxChunksToSorted(arr: IntArray): Int {
  // 一旦发现数字比索引更大，开始记录，往后遍历直到找到最小索引和最大索引中间所有的数，分为一块
  var ans=0
  val s = mutableSetOf<Int>() // 每个块中需要找到的数
  var max=-1
  for(i in arr.indices){
    if(arr[i]>i){
      if (max==-1){
        max=arr[i]
        for (j in i until arr[i]){
          s.add(j)
        }
      }else if(arr[i]>max){
        // 块没结束，又发现更大的
        for (j in max+1 until arr[i]){
          s.add(j)
        }
        max=arr[i]
      }else{
        s.remove(arr[i])
        if (s.isEmpty()) {
          ans++
          max=-1
        }
      }
    }else if(arr[i]==i){
      if(max==-1) ans++
      else{
        s.remove(arr[i])
        if(s.isEmpty()){
          ans++
          max=-1
        }
      }
    }else{
      // 比索引小，肯定在块里，否则前面都排好了，不可能出现在这里
      s.remove(arr[i])
      if(s.isEmpty()){
        ans++
        max=-1
      }
    }
  }
  return ans
}