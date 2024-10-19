class Solution {

    fun minOperations(nums: IntArray): Int {
        val n = nums.size
        var opCnt = 0
        for(i in 0 until n){
            if((nums[i]+opCnt)%2==0){
                opCnt++
            }
        }
        return opCnt
    }
}