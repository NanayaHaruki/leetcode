package easy.string

/**
 *@Author:
 *@Description:有效的字母异位词
 *@Date: 15:24 2019/2/21
 */

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
//
//示例 1:
//
//输入: s = "anagram", t = "nagaram"
//输出: true
//示例 2:
//
//输入: s = "rat", t = "car"
//输出: false
//说明:
//你可以假设字符串只包含小写字母。
//
//进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
fun isAnagram(s: String, t: String): Boolean {
    if (s.length!=t.length) return false
    val map = mutableMapOf<Char,Int>()
    s.forEach {
        val count = map.getOrDefault(it, 0)
        map[it] = count+1
    }
    t.forEach {
        val count = map.getOrDefault(it, 0)
        when (count) {
            0 -> return false
            1 -> map.remove(it)
            else -> map[it] = count -1
        }
    }
    return map.isEmpty()
}