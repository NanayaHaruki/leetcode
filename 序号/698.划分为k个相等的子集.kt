class Solution {
  
  // 执行用时：200 ms, 在所有 Kotlin 提交中击败了100.00% 的用户
  // 内存消耗：35.1 MB, 在所有 Kotlin 提交中击败了66.67% 的用户
  // 通过测试用例：162 / 162
    val used = BooleanArray(16)
    fun canPartitionKSubsets(nums: IntArray, _k: Int): Boolean {
      val sum = nums.sum()
      if (sum % _k != 0) return false
      val average = sum / _k
      // 每个桶里装average
      nums.sortDescending()
      
      /**
       * @param indexBall 装第几个球
       * @param indexBucket 正在装第几个桶
       * @param _cur 当前桶里的球的和
       * */
      fun backTrace(indexBall:Int, indexBucket: Int, cur: Int): Boolean {
        if (indexBucket == _k) return true // 每个桶都装完了
        if (cur==average) return backTrace(0,indexBucket+1,0) // 这个桶满了，找下一个桶，装下一个球
        if (indexBall==nums.size) return false // 角标越界了
        for (i in indexBall until nums.size) {
          if (used[i]|| cur+nums[i]>average) continue
          used[i] = true
          if(backTrace(i+1,indexBucket,cur+nums[i])) return true
          used[i] = false
          if (cur==0) return false
        }
        return false
      }
      return backTrace(0, 0,0)
    }
  
  /*
  lateinit var ns:IntArray
  lateinit var ts :IntArray
  var k = 0
  fun canPartitionKSubsets(nums: IntArray, _k: Int): Boolean {
    // 数组nums 分成和相等的k个子集
    k = _k
    val sum = nums.sum()
    if (sum%k!=0) return false
    val t = sum/k
    ns=nums
    ts = IntArray(k){t}
    ns.sortDescending()
    return dfs(0)
  }
  
  fun dfs(i:Int):Boolean{
    if (i==ns.size && ts.sum()==0) return true
    for (j in 0 until k){
      if (ns[i]>ts[j]) continue
      ts[j]-=ns[i]
      if(dfs(i+1)) return true
      ts[j]+=ns[i]
    }
    return false
  }
  
   */
}