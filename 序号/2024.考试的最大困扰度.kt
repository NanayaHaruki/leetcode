class Solution {
  fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
    return maxOf(maxConsecutiveAnswersByChar(answerKey, k, 'F'), maxConsecutiveAnswersByChar(answerKey, k, 'T'))
  }
  
  fun maxConsecutiveAnswersByChar(answerKey: String, k: Int, target: Char): Int {
    // k次操作 让answer的字符变得连续
    // 首先想到dp，但是会超时。 用滑动窗口，右边界不断右移，统计另一种字符的个数，如果超过k，说明无法替换，左边界右移缩小窗口长度，直到k能满足。
    // 右边界到达最大角标时，推出循环，返回窗口最大长度
    var (l, r) = 0 to 0
    var fCnt = 0
    var ans = 0
    while (r < answerKey.length) {
      if (answerKey[r] == target) fCnt++
      while (fCnt > k) {
        l++
        if (answerKey[l - 1] == target) fCnt--
      }
      ans = maxOf(ans, r - l + 1)
      r++
    }
    return ans
  }
}