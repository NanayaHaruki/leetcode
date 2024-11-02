class Solution {
    fun minChanges(n: Int, k: Int): Int {
        var cnt = 0
        for(i in 0..30){
            if(n.shr(i).and(1) ==0 && k.shr(i).and(1)==1) return -1 // 0变不了1
            if(n.shr(i).and(1)==1 && k.shr(i).and(1)==0) cnt++
        }
        return cnt
    }
}