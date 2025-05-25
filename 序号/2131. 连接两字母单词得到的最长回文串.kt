class Solution {
    fun longestPalindrome(words: Array<String>): Int {
        // 因为Words[i]长度固定为2，想组成回文必定要一对 ab ba,
        // 如果有w两个字符相同，可以放中间
        var ans = 0
        val cnts = mutableMapOf<String,Int>()
        val sameWords = mutableMapOf<String,Int>()
        for(w in words){
            val op = w.reversed()
            if(cnts.contains(op)) {
                ans+=4
                cnts.computeIfPresent(op){_,v->if (v==1) null else v-1}
                if(w[0]==w[1]) sameWords.computeIfPresent(w){_,v->if(v==1) null else 1}
            }else {
                cnts.merge(w, 1, Int::plus)
                if(w[0]==w[1]) sameWords.merge(w,1,Int::plus)
            }
        }
        return ans + if(sameWords.isNotEmpty()) 2 else 0
    }
}