// 反转字符串
class Solution {
    fun reverseString(s: String): String {
       //kotlin直接提供了官方api。。但作为题目还是不用了吧
       val charArr = s.toCharArray()
       for(i in 0 until (charArr.size / 2)) {
       		val temp = charArr[i]
       		charArr[i] = charArr[charArr.size -1 - i]
       		charArr[charArr.size -1 -i] = temp
       }
       return String(charArr)
    }
}
