class Solution {
  fun minOperations(nums: IntArray, k: Int): Int {
      // 选择一个数x，nums中大于x的数必须一样。 就这些数变成x。 最终全变成k
      // k<=min(nums),才能成功。因为数只能变小
      val ts = nums.toSortedSet()
      val mn = ts.first()
      if(mn<k) return -1
      return if(mn==k)  ts.size-1 else ts.size
  }
}