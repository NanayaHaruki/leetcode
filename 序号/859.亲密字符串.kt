class Solution {
    fun buddyStrings(s: String, goal: String): Boolean {
        val arr1 = s.toCharArray()
        val arr2 = goal.toCharArray()
        if (s == goal) {
            // 找重复字符
            val dict = mutableMapOf<Char, Int>()
            for (c in arr1) {
                dict[c] = dict.getOrDefault(c, 0) + 1
                if (dict[c]!! > 1) return true
            }
            return false
        }
        if (arr1.size != arr2.size) return false
        var diffCnt = 0
        var a: Char? = null
        var b: Char? = null
        for (i in arr1.indices) {
            if (arr1[i] != arr2[i]) {
                diffCnt++
                if (diffCnt > 2) return false
                if (a == null) {
                    a = arr1[i]
                    b = arr2[i]
                } else {
                    if (arr1[i] == b && arr2[i] == a) {
                        a = null
                        b = null
                        continue
                    } else {
                        return false
                    }
                }
            }
        }
        return diffCnt!=1
    }
}