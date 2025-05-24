class Solution {
    fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
        val ans = mutableListOf<Int>()
        words.forEachIndexed{i,w->
            for(c in w){
                if(c==x){
                    ans.add(i)
                    break
                }
            }
        }
        return ans
    }
}