class Solution {
    fun clearStars(s: String): String {
        val n = s.length
        val removeIdx = BooleanArray(n){false}
        // char小的在堆顶，一样的char索引大的在堆顶
        val pq = PriorityQueue<Pair<Char,Int>>{a,b-> if(a.first==b.first) b.second-a.second else a.first-b.first}
        s.forEachIndexed { i, c ->
            if (c=='*'){
                removeIdx[pq.poll().second]=true
                removeIdx[i]=true
            } else  {
                pq.add(c to i)
            }
        }
        val sb = StringBuilder()
        for(i in 0 until n){
            if(!removeIdx[i]) sb.append(s[i])
        }
        return sb.toString()
    }
}