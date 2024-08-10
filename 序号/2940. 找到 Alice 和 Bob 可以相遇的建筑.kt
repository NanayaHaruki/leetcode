class Solution {
    fun leftmostBuildingQueries(heights: IntArray, queries: Array<IntArray>): IntArray {
        val ans = IntArray(queries.size){-1}
        val qs = Array(heights.size){ mutableListOf<Pair<Int,Int>>() } // qs[b] 存的是问题 a<b && height[a]>height[b]，存放的是(height[a],b)
        for(i in queries.indices){
            var (a,b) = queries[i]
            if(a>b){
                val c=b
                b=a;a=c
            }
            // 能直接回答的，直接回答
            if(a==b || heights[a]<heights[b]) ans[i]=b
            // 不能直接回答的，存起来，待会回答
            else qs[b].add(heights[a] to i)
        }
        // 搞个最小堆，在遍历height时，堆中存放的是a<b<i，且height[a]>height[b]的问题
        // 如果堆顶小于height[i]，则i为答案，一直循环将堆中的问题都回答掉
        // 堆中的问题，ab都要小于i，所以在遍历完i时，再将b的问题放入堆
        val h = PriorityQueue<Pair<Int,Int>> { o1, o2 -> if (o1.first<o2.first) -1 else 1 }
        for (i in heights.indices){
            while (h.isNotEmpty() && h.peek().first < heights[i]){
                ans[h.poll().second]=i 
            }
            for (p in qs[i]){
                h.offer(p)
            }
        }
        return ans
    }
}