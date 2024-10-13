class Solution {
    fun twoEggDrop(n: Int): Int {
        var d = 1
        var m = n
        var cnt = 0
        while(m>0){
            m-=d
            d+=1
            cnt++
        }
        return cnt
    }
}