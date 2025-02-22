class Solution {
    fun similarPairs(words: Array<String>): Int {
        val n = words.size
        val cnts = mutableMapOf<String,Int>()
        words.forEachIndexed{i,w->
            val sb = StringBuilder()
            val chars = w.toCharArray().sorted()
            for (c in chars){
                if(sb.isEmpty()) sb.append(c)
                else if(c!=sb.last()) sb.append(c)
            }
            val k = sb.toString()
            if(cnts.containsKey(k)) cnts[k]=cnts[k]!!+1
            else cnts[k]=1
        }
        var ans = 0
        for(v in cnts.values){
            if (v==1)continue
            ans += v*(v-1)/2
        }
        return ans
    }
}