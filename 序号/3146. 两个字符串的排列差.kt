class Solution {
    fun findPermutationDifference(s: String, t: String): Int {
        val n = s.length
        val charToIndex = IntArray(26)
        for(i in 0 until n){
            charToIndex[t[i]-'a']=i // 因为字符不重复，记录这个字符的位置
        }
        var ans = 0
        for(i in s.indices){
            ans+=abs(i-charToIndex[s[i]-'a'])
        }
        return ans
    }
}