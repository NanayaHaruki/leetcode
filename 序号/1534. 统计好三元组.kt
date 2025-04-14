import kotlin.math.abs
class Solution {
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        val n = arr.size
        var ans = 0
        for(i in 0 .. n-3){
            for(j in i+1 .. n-2){
                if(abs(arr[i]-arr[j])>a) continue
                for(k in j+1 .. n-1){
                    if(abs(arr[i]-arr[k])<=c && abs(arr[j]-arr[k])<=b){
                        ans++
                    }
                        
                }
            }
        }
        return ans
    }
}