class Solution {
    fun distanceBetweenBusStops(distance: IntArray, start: Int, destination: Int): Int {
        val a = min(start,destination)
        val b = max(start,destination)
        val sm = distance.sum()
        var cnt = 0
        for (i in a until b){
            cnt+=distance[i]
        }
        return min(cnt,sm-cnt)
    }
}