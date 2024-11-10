class Solution {
    fun singleNonDuplicate(nums: IntArray): Int {
        var a = 0
        for(x in nums){
            a = a xor x
        }
        return a
    }
}