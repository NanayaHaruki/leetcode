// 返回一个字符串第一个不重复字符的角标
class Solution {
    fun firstUniqChar(s: String): Int {
        val map = mutableMapOf<Char,IntArray>()
//        intArray 第一个数存放第一次出现的index，第二个数存放出现次数，当下次再次出现只改变出现次数
        for(i in s.indices) {
            if(!map.contains(s[i])) map[s[i]] = intArrayOf(i,1)
            else {
                val pair = map[s[i]]
                pair!![1] = pair[1] + 1
            }
        }
        var index = s.length
        map.forEach { char, intArray ->
            if (intArray[1] == 1 && intArray[0] < index) {
                index = intArray[0]
            }
        }
        return if(index == s.length) -1
        else index
    }
}
