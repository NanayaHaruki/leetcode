class Solution {
    fun minimumOperationsToMakeKPeriodic(word: String, k: Int): Int {
        val n = word.length
        val mp = mutableMapOf<String,Int>()
        for(i in 0 until n step k){
            val sub = word.substring(i,i+k)
            mp[sub]=mp.getOrDefault(sub,0)+1
        }
        return n/k - mp.values.max()
    }
}