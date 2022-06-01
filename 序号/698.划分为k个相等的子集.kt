class Solution {
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
}