
/**
执行用时：320 ms, 在所有 Kotlin 提交中击败了14.29% 的用户
内存消耗：38.2 MB, 在所有 Kotlin 提交中击败了28.57% 的用户
通过测试用例：121 / 121
 *
 * */
class Solution {
  // piles是n堆香蕉，数组表示每堆多少根，h是时间，求吃光最小速度，一小时最多吃一堆
  lateinit var piles: IntArray
  var h = 0
  fun minEatingSpeed(_piles: IntArray, _h: Int): Int {
    // 最慢速度是香蕉总量/时间，最快速度是堆数最大值（h>=piles.length，且一次只能吃一堆)
    // 不断二分，求满足条件的最小left
    // 二分容易，怎么判断满足条件
    
    piles = _piles.sortedArrayDescending()
    var sum = 0;var max = 0
    for (banana in piles){
      sum+=banana
      max= maxOf(banana,max)
    }
    h = _h
    var l = if(sum/h>1) sum/h else 1
    var r = max
    while (l <= r) {
      val m = l + ((r - l) shr 1)
      if (judge(m)) {
        r = m - 1
      } else {
        l = m + 1
      }
    }
    return l
  }
  
  fun judge(v: Int): Boolean {
    var time = 0
    for (i in piles.indices) {
      val banana = piles[i]
      // 数组倒序排序过了，出现一次能吃掉一堆的情况，后面的不用遍历了，剩几堆就需要几小时吃完
      if (banana <= v) {
        time += (piles.size - i)
        break
      }
      time += banana / v
      if (banana % v != 0) time += 1
    }
    return time <= h
  }
}