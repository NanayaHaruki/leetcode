// s的每2k个字符 反转前k个字符，不足k则全部反转
class Solution {
    fun reverseStr(s: String, k: Int): String {
        val chars = s.toCharArray()
        for (i in s.indices step 2 * k) {
            var start = i
            var end = Math.min(s.length-1,start+k-1)
            while (start < end) {
                val temp = chars[start]
                chars[start++] = chars[end]
                chars[end--] = temp
            }
        }
        return String(chars)
    }
}
