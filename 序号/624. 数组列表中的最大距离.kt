class Solution {
  fun maxDistance(arrays: List<List<Int>>): Int {
    // 找最小的和最大的  如果最小最大在同一数组里，找次下和次大的。用次小和最大的差 和 最小次大的差比
    val m = arrays.size
    var mn = 10001
    var mx = -10001
    var ans = 0
    for(a in arrays){
      ans = max(ans,max(a.last()-mn,mx-a.first()))
      mx = max(mx,a.last())
      mn = min(mn,a[0])
    }
    return ans
  }
}