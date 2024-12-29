class Solution {
    fun rankTeams(votes: Array<String>): String {
        val m = votes[0].length
        val l = Array(26){ IntArray(m+1).apply{this[m]=it}}
        votes.forEach {
            it.forEachIndexed { index, c ->
                l[c-'A'][index]++
            }
        }
        l.sortWith{a,b->
            for (i in 0 until m){
                if (a[i]==b[i]) continue
                return@sortWith -a[i]+b[i]
            }
            return@sortWith 0
        }
        val sb = StringBuilder()
        for (i in 0 until m){
            sb.append('A'+l[i][m])
        }
        return sb.toString()
    }
}