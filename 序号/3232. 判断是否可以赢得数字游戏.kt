class Solution {
    fun canAliceWin(nums: IntArray): Boolean {
        var a =0
        var b = 0
        for(x in nums){
            if(x<10) a+=x
            else b+=x
        }
        return a!=b
    }
}