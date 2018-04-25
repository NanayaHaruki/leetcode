class Solution {
    fun countSegments(s: String): Int {
       return if(s.isBlank()) 0 else s.trim().split(Regex(" +")).size
    }
}
