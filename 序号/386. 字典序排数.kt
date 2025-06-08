class Solution {
    
    fun lexicalOrder(n: Int): List<Int> {
        val ans = mutableListOf<Int>()
        fun dfs(cur:Int){
            if(cur>n) return
            ans.add(cur)
            for(i in 0..9) dfs(cur*10+i)
         }
        for(i in 1..9) dfs(i)
        return ans
    }
}