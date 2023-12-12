class Solution {
  fun secondGreaterElement(nums: IntArray): IntArray {
    // 求每个元素的下下个元素
    // 求下个元素可以用单调栈，维护栈顶为最大的，当要弹栈意味着出现更大的元素了。一次弹多个则这多个元素的下个更大元素都是当前这个让他们弹出去的
    // 下下个元素就用两个栈
    val s = mutableListOf<Int>()
    val t = mutableListOf<Int>()
    val ans = IntArray(nums.size){-1}
    for (i in nums.indices){
      while(t.isNotEmpty() && nums[t.last()]<nums[i]){
        ans[t.last()]=nums[i]
        t.removeLast()
      }
      var j = s.lastIndex
      while(j>=0 && nums[s.last()]<nums[i]){
        --j
      }
      val sub = s.subList(j+1,s.size)

      t.addAll(sub)
      sub.clear()
      s.add(i)
    }
    return ans
  }
}