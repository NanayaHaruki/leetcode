package easy.string

/**
 *@Author: xzj
 *@Description: 字符串中的第一个唯一字符
 *@Date: 15:00 2019/2/21
 */

fun firstUniqChar(s: String): Int {
    // 数组arr表示a~z出现的个数
    val charAsciiArr = IntArray(26)
    // 第一遍遍历，将个数存入26长度的数组
    s.forEach { c ->
        charAsciiArr[c - 'a']++
    }
    // 第二遍遍历，选出第一个出现次数为1的字符
    s.forEachIndexed { index, c ->
        if (charAsciiArr[c - 'a'] == 1) {
            return index
        }
    }
    return -1
}