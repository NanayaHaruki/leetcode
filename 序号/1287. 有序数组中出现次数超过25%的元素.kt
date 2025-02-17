class Solution {
    fun findSpecialInteger(arr: IntArray): Int {
        var a = 0
        var cnt = 0
        val n = arr.size
        for(x in arr){
            if(x==a){
                ++cnt
            }else{
                a=x
                cnt=1
            }
            if(cnt*4>n){
                    return a
            }
        }
        return -1
    }
}