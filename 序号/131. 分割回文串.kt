class Solution {
    fun check(i:Int,j:Int):Boolean{
        var (l,r)=i to j
        while(l<r){
            if(s[l++]!=s[r--]) return false
        }
        return true
    }
    lateinit var s:String
    var n = 0

    fun dfs(i:Int):List<List<String>>{
        if (i==n) return emptyList()
        val res = mutableListOf<List<String>>()
        for (j in i until n){
            val pre = s.substring(i,j+1)
            if(!check(i,j)) continue
            if (j==n-1) {
                res.add(listOf(pre))
            }else {
                val suffix = dfs(j + 1)
                val cur = listOf(pre)
                for (x in suffix) {
                    res.add(cur + x)
                }
            }
        }
        return res
    }
    fun partition(_s: String): List<List<String>> {
        s=_s
        n=s.length
        return dfs(0)
    }
}