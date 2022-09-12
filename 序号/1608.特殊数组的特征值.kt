class Solution {
  fun specialArray(nums: IntArray): Int {
    nums.sort()
    var l = 0
    var r = 1000
    while (l<=r){
      val m = (l+r)/2
      val cnt = search(nums,m)
      if (cnt==m) return m
      else if(cnt<m) {
        r=m-1
      }else {
        l=m+1
      }
    }
    return -1
  }
  
  fun search(nums:IntArray,target:Int):Int{
    // 检查数组中大于等于a的数有几个
    // 该数不存在于数组，返回值为负数
    // 比该数大的数有  ret+size+1
    // 比该数小的数有  1-ret
    
    // 该数存在于数组，返回的是索引，则大于该数的数有 size-ret-1
    // 小于该数的数有 ret个
    // 大于等于或小于等于的情况，将上面两个式子+1
    var l = 0;var r = nums.size-1
    while(l<=r){
      val m = l+(r-l)/2
      val b = nums[m]
      if (b<target) l=m+1
      else if(b==target) r=m-1
      else r=m-1
    }
    return if (l==-1) nums.size
    else if(l==nums.size) 0
    else nums.size-l  // 0 1 3
  }
}