fun duplicateZeros(arr: IntArray): Unit {
  // 将0重复，后面数字顺延
  val n = arr.size
  val ans = mutableListOf<Int>()
  for(i in arr){
    if(i==0) {
      ans.add(0)
      ans.add(0)
    }else{
      ans.add(i)
    }
    if(ans.size>=n) break
  }
  for(i in 0 until n){
    arr[i]=ans[i]
  }
}