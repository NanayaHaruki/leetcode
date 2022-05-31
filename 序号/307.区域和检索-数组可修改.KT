class NumArray(val nums: IntArray) {
  val tree = IntArray(nums.size+1)
  init {
    for (i in nums.indices){
      var j = i+1
      while (j<=nums.size){
        tree[j]+=nums[i]
        j+=lowerBit(j)
      }
    }
  }
  fun lowerBit(i:Int):Int{
    return i and -i
  }
  
  fun sum(i:Int):Int{
    var j = i;var ans=0
    while (j>0){
      ans+=tree[j]
      j-=lowerBit(j)
    }
    return ans
  }
  
  fun update(index: Int, `val`: Int) {
    var j = index+1;val diff = `val`-nums[index]
    while (j<=nums.size){
      tree[j]+=diff
      j+=lowerBit(j)
    }
    nums[index]=`val`
  }
  
  fun sumRange(left: Int, right: Int): Int {
    return sum(right+1)-sum(left)
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * obj.update(index,`val`)
 * var param_2 = obj.sumRange(left,right)
 */