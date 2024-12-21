class Solution {
    fun sortTheStudents(score: Array<IntArray>, k: Int): Array<IntArray> {
        score.sortWith{a,b->b[k]-a[k]}
        return score
    }
}