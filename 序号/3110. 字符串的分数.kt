class Solution {
    fun scoreOfString(s: String): Int {
        var ans = 0
        for(i in 0 until s.length-1){
            ans+=abs(s[i+1]-s[i])
        }
        return ans
    }
}