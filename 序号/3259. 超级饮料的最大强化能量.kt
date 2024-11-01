class Solution {
    fun maxEnergyBoost(energyDrinkA: IntArray, energyDrinkB: IntArray): Long {
        var a:Long = energyDrinkA[0].toLong()
        var b:Long = energyDrinkB[0].toLong()
        var c = 0L
        for(i in 1 until energyDrinkA.size){
            val tmpC = c
            c=max(a,b)
            a=max(a+energyDrinkA[i],tmpC+energyDrinkA[i])
            b=max(b+energyDrinkB[i],tmpC+energyDrinkB[i])
           
        }
        return longArrayOf(a,b,c).max()
    }
}