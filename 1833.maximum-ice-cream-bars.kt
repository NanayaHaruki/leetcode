class Solution {
    fun maxIceCream(costs: IntArray, coins: Int): Int {
        costs.sort()
        var left = coins
        for (i in costs.indices){
            left-=costs[i]
            if (left<0){
                return i
            }
        }
        return costs.size
    }
}