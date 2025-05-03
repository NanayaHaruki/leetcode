class Solution {
    fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
        val n = tops.size
        var ans = n
        
        for(k in 1..6){
            var a = 0
            for(i in 0 until n){
                if(tops[i]==k) continue
                if(bottoms[i]==k) a++
                else {a=n
                break}
            }
            var b = 0
            for(i in 0 until n){
                if(bottoms[i]==k) continue
                if(tops[i]==k) b++
                else {b=n
                break}
            }
            min(a, b).let { ans=min(ans,it) }
        }
        return if(ans==n) -1 else ans
    }
}