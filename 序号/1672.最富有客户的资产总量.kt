fun maximumWealth(accounts: Array<IntArray>): Int {
  var sum = Int.MIN_VALUE
  for(arr in accounts){
    sum = maxOf(sum,arr.sum())
  }
  return sum
}