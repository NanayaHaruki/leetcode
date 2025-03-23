class Solution {
    fun canBeValid(s: String, locked: String): Boolean {
        val n = s.length
        if(n.and(1)==1) return false
        var mx = 0
        var mn = 0
        for(i in 0 until n){
            val c = s[i]
            val lock = locked[i]
            if(lock=='1'){
                val diff = if(c=='(') 1 else -1
                mx+=diff
                mn+=diff
            }else{
                mx+=1
                mn-=1
            }
            if(mx<0) return false
            if(mn<0) mn=1
        }
        return mn==0
    }
}