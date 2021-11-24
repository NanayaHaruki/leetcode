class Solution {
    fun originalDigits(s: String): String {
        // 2608374519
        // W X Z G T S R V O
        val words = listOf("two","six","zero","eight","three","seven","four","five","one","nine")
        val keyChars = listOf('w','x','z','g','t','s','r','v','o','n')
        val nums = listOf(2,6,0,8,3,7,4,5,1,9)
        // 存放每个字符出现次数
        val charCnt = IntArray(26)
        for (c in s) charCnt[c-'a']++
        val ans = StringBuilder()
        // 按照固定顺序检查数字是否存在
        for (i in 0..9){
            while (charCnt[keyChars[i] - 'a'] > 0) {
                // 如果有关键字符，字符数组中减去整个单词
                for (c in words[i]) charCnt[c-'a']--
                // 答案增加单词对应的数字
                ans.append(nums[i])
            }
        }
        val arr = ans.toString().toCharArray()
        arr.sort()
        return String(arr)
    }
}