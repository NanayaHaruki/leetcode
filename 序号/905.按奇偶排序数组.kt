fun sortArrayByParity(nums: IntArray): IntArray {
  // 偶数移动到奇数前面去
  // 双指针，左指针从左到右找奇数，右指针从右到左找偶数，找到一个对调一次
  var l = 0
  var r = nums.lastIndex
  while (l<r){
    while (nums[l]%2==0 && l<r){
      l++
    }
    while (nums[r]%2!=0 && r>l){
      r--
    }
    if (l<r) {
      /*
    nums[l]=nums[l] xor nums[r]
    nums[r]=nums[l] xor nums[r]
    nums[l]=nums[l] xor nums[r]
    */
      val tmp = nums[r]
      nums[r]=nums[l]
      nums[l]=tmp
    }
  }
  return nums
}