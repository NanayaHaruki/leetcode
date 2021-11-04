class Solution {
    fun longestPalindrome(s: String): String {
        // 单个字符都是回文，往两边探索，找最大长度，遇到边界或者左右字符不同就返回；
        // 探索i和i+1 如果相同，以双字符开始向两边探索
        val chars = s.toCharArray()
        val n = s.length
        var ansLen = 1
        var ansStart = 0
        for (i in 0..n - 2) {
            // 以i为中心找奇数回文
            var oddLen = 1
            while (i - oddLen >= 0 && i + oddLen < n) {
                if (chars[i - oddLen] == chars[i + oddLen]) {
                    oddLen++
                } else {
                    break
                }
            }
            // 不管是超越边界跳出while，还是两边不同break出来，len都超了1
            oddLen--
            val oddTotalLen = oddLen * 2 + 1
            if (oddTotalLen>ansLen){
                ansLen=oddTotalLen
                ansStart=i-oddLen
            }

            // 找偶数回文
            if (chars[i] == chars[i + 1]) {
                var evenLen = 1
                while (i - evenLen >= 0 && i + 1 + evenLen < n) {
                    if (chars[i - evenLen] == chars[i + 1 + evenLen]) {
                        evenLen++
                    }else {
                        break
                    }
                }
                evenLen--
                val evenTotalLen = evenLen*2+2
                if (evenTotalLen>ansLen){
                    ansLen=evenTotalLen
                    ansStart = i-evenLen
                }
            }
        }
        return s.substring(ansStart,ansStart+ansLen)
    }
}