import kotlin.math.*

class Solution {
    fun maxScoreSightseeingPair(values: IntArray): Int {
        // values为景点得分  一对景点得分为得分和-距离  返回一对景点的最高得分
        // score = values[i]+values[j]+i-j = (values[i]+i)+(values[j]-j) 括号里的可以在遍历时更新
        var maxI = values[0]
        var ans = 0
        for (j in 1 until values.size){
            ans = max(ans,maxI+values[j]-j)
            maxI = max(maxI,values[j]+j)
        }
        return ans
    }
}