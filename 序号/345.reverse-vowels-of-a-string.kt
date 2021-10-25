// 反转字符串中的元音
// Given s = "hello", return "holle".
class Solution {
     fun reverseVowels(s: String): String {
        // 先遍历一遍找出元音的角标，然后替换
        val vowelIndexList = mutableListOf<Int>()
        for(i in s.indices) {
            val c = s[i]
            when(c) {
                'a','i','u','e','o' -> vowelIndexList.add(i)
            }
        }
        val charArr = s.toCharArray()
        for(index in 0 until vowelIndexList.size/2) {
            val temp = charArr[vowelIndexList[index]]
            charArr[vowelIndexList[index]] = charArr[vowelIndexList[vowelIndexList.size-1-index]]
            charArr[vowelIndexList[vowelIndexList.size-1-index]] = temp
        }
        return String(charArr)
    }


    /** 双指针 */
    fun reverseVowels(s: String): String {
        val arr = s.toCharArray()
        val target = charArrayOf('a','o','e','i','u','A','E','I','O','U')

        var l = 0
        var r = arr.lastIndex
        while (l<r) {
            val lChar = arr[l]
            val rChar = arr[r]
            when {
                lChar in target && rChar in target->{
                    // 互换
                    arr[l]=rChar
                    arr[r]=lChar
                    l++
                    r--
                }
                lChar in target && rChar !in target->{
                    r--
                }
                lChar !in target && rChar in target->{
                    l++
                }
                else ->{
                    l++
                    r--
                }
            }
        }
        return String(arr)
    }
}
