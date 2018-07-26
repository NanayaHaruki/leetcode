// 压缩字符数组，重复的字符用数字表示重复次数，数组中每个元素的长度都是1
// Input:
// ["a","a","b","b","c","c","c"]
// Output:
// Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
class Solution {
    fun compress(chars: CharArray): Int {
        val ascii = IntArray(128)
        for (c in chars) {
            ascii[c.toInt()]++
        }
        var size = 0
        ascii.forEachIndexed { index, i ->
            when (i) {
                1 -> size++
                0 -> {}
                else -> size += (i.toString().length + 1)
            }
        }
        return size
    }
}
