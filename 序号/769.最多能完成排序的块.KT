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