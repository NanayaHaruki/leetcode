package easy.string

/**
 *@Author:
 *@Description:验证回文字符串
 *@Date: 9:45 2019/2/22
 */

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
//说明：本题中，我们将空字符串定义为有效的回文串。
//
//示例 1:
//
//输入: "A man, a plan, a canal: Panama"
//输出: true
//示例 2:
//
//输入: "race a car"
//输出: false

fun isPalindrome(s: String): Boolean {
    val diff = 'a' - 'A'
    val charList = mutableListOf<Char>()
    s.forEach {
        when (it) {
            in '0'..'9' -> charList.add(it)
            in 'a'..'z' -> charList.add(it)
            in 'A'..'Z' -> charList.add(it + diff) //不考虑大小写，那就将大写都转成小写
        }
    }
    var index = 0
    for (i in s.lastIndex downTo 0) {
        val c = s[i]
        when (c) {
            in '0'..'9',
            in 'a'..'z' -> if (c != charList[index]) {
                return false
            } else index++
            in 'A'..'Z' -> if (c+diff != charList[index]) {
                return false
            } else index++
        }
    }
    return true
}