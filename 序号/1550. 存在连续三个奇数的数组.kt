class Solution {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        for(i in 0 .. arr.size-3){
            if(arr[i]%2==1 && arr[i+1]%2==1 && arr[i+2]%2==1) return true
        }
        return false
    }
}