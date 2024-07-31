class Solution {
    fun minRectanglesToCoverPoints(points: Array<IntArray>, w: Int): Int {
        points.sortBy { it[0] }
        var ans=0
        var preX = Int.MIN_VALUE
        for((x,_) in points){
            if (preX+w<x){
                ans+=1
                preX=x
            }
        }
        return ans
    }
}