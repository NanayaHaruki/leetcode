fun arrayNesting(nums: IntArray): Int {
  // 按题意模拟，将遍历过的数更改为-1. 后面再遇到-1说明进环了，寻找最大的环不能进小环
  var ans = 0
  for(i in nums.indices){
    var cnt = 0;var j = i
    while(nums[j]!=-1){
      cnt++
      val k = j
      j=nums[j]
      nums[k]=-1
    }
    ans = maxOf(ans,cnt)
  }
  return ans
}