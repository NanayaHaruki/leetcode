class Solution {
    
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val n = gas.size
        var start = 0
        var curGas = 0
        for(i in 0 until n){
            curGas+=gas[i]-cost[i]
            if(curGas<0){
                start=i+1
                curGas=0
            }
        }
        for(i in 0 until start){
            curGas+=gas[i]-cost[i]
            if(curGas<0) return -1
        }
        return start
    }
}