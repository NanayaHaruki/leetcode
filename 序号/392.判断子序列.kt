class Solution {

    fun isSubsequence(s: String, t: String): Boolean {
        // 判断s为t的子序列
        // 双指针 s的指针走完了都能在t里找到对应字符就是子序列
        if (s.isEmpty()) return true
        if (t.isEmpty()) return false
        val arrS = s.toCharArray()
        val arrT = t.toCharArray()
        var pt = 0 // t的指针
        var allFind = false
        for (ps in arrS.indices) {
            var find = false
            for (p in pt until t.length) {
                if (arrS[ps] == arrT[p]) {
                    pt = p+1
                    find = true
                    break
                }
            }
            if (!find) {
                // 当前的没找到，退出循环，返回false
                break
            } else {
                // 最后一个都找到了，改变标记，返回true
                if (ps == arrS.lastIndex) {
                    allFind = true
                }
            }
        }
        return allFind
    }
}