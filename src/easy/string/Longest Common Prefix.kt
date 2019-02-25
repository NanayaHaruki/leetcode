package easy.string

/**
 *@Author:
 *@Description: 最长公共前缀
 *@Date: 15:49 2019/2/25
 */
//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
//
//示例 1:
//
//输入: ["flower","flow","flight"]
//输出: "fl"
//示例 2:
//
//输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//说明:
//
//所有输入只包含小写字母 a-z 。

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty() || strs.first().isEmpty()) return ""
    var minLen = Int.MAX_VALUE
    var minStr = ""
    strs.forEach {
        if (it.length< minLen) {
            minLen = it.length
            minStr = it
        }
    }
    var searchLen = 1
    while (searchLen <= minStr.length) {
        val target = minStr.substring(0, searchLen)
        strs.forEach {
            if (!it.startsWith(target)) {
                return target.dropLast(1)
            }
        }
        searchLen++
    }
    return minStr
}