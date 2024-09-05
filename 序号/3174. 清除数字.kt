
class Solution {
    fun clearDigits(s: String): String {
        val t = mutableListOf<Char>()
        for(c in s){
            if(c in '0'..'9'){
                if(t.isNotEmpty()) t.removeLast()
            }else{
                t.add(c)
            }
        }
        return  t.joinToString(separator = "")
    }
}