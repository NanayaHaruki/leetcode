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

    /** 210820 */
    fun reverseStr(s: String, k: Int): String {
        // 每2k翻转k个字符  k个翻转，不够k全翻  再k个不翻，不够k的也不翻
        val arr = s.toCharArray()
        for (i in 0..arr.size step k*2){
            reverse(arr,i,k)
        }
        return String(arr)
    }

    fun reverse(charArray: CharArray, index: Int, len: Int) {
        var l = index
        var r = l + len - 1
        if (charArray.lastIndex<r) r = charArray.lastIndex
        while (l<r){
            val tmp = charArray[l]
            charArray[l]=charArray[r]
            charArray[r]=tmp
            l++
            r--
        }
    }
}
