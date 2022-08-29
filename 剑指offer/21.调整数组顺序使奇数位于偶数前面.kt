fun exchange(nums: IntArray): IntArray {
  var l = 0;var r = nums.size-1
  while(l<r){
    if(nums[l]%2==1) {
      l++
      continue
    }
    // 偶数放到数组后面去，从后往前找第一个奇数，和前面出现的偶数对调
    while(l<r && nums[r]%2==0) r--
    if(l<r && nums[r]%2==1) { // 找到了就换，找不到就不用干活了
      val t = nums[r]
      nums[r]=nums[l]
      nums[l]=t
      l++
      r--
    }
  }
  return nums
}