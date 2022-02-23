class Solution {
  fun reverseOnlyLetters(s: String): String {
    var (l, r) = 0 to s.length - 1
    val arr = s.toCharArray()
    while (l < r) {
      if (!arr[l].isLetter()) {
        l++
      } else if (!arr[r].isLetter()) {
        r--
      } else {
        val tmp = arr[r]
        arr[r] = arr[l]
        arr[l] = tmp
        l++
        r--
      }
    }
    return String(arr)
  }
}