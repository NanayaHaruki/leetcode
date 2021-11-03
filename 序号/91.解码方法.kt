class Solution {
    fun isZero(char: Char) = char == '0'
    fun numDecodings(s: String): Int {

        // 1.base case f[i-2] = 0 f[i-1]=1 f[i] = 0

        // 2. 当前字符能解析成数字，f[i] = f[i-1]   条件：f[i]!=0
        // 使用2个字符解析成数字，f[i] = f[i-2]  条件：f[i-2]为1或2  f[i-1]为0~6
        // 状态 转移方程 f[i] = f[i-1]+f[i-2]

        // 3. 只用记录f[i-2] 和f[i-1]，使用状态压缩
        if (isZero(s[0])) return 0
        if (s.length == 1) return 1
        var pre2 = 1

        var pre1 = if (isZero(s[1])) {
            if (s[0] == '1' || s[0] == '2') 1 else 0
        } else {
            if ("${s[0]}${s[1]}".toInt() <= 26) 2 else 1
        }
        if (s.length==2) return pre1

        var curr = 0
        for (i in 2..s.lastIndex) {
            curr = 0
            if (s[i] != '0') {
                curr += pre1
            }
            if (s[i - 1] != '0' && "${s[i-1]}${s[i]}".toInt() <= 26) {
                curr += pre2
            }
            pre2 = pre1
            pre1 = curr

        }
        return curr
    }
}