class Solution {
    fun minSetSize(arr: IntArray): Int {
        val d = mutableMapOf<Int,Int>()
        for(x in arr){
            d[x]=d.getOrDefault(x,0)+1
        }
        // 按value排序
        val pq = PriorityQueue<IntArray>(){a,b->b[0]-a[0]}
        for ((k,v) in d.entries){
            pq.offer(intArrayOf(v,k))
        }
        val n = arr.size
        var ans = 0
        var cnt = 0
        while(pq.isNotEmpty()){
            val (v,k) = pq.poll()
            cnt+=v;ans++
            if(cnt>=n/2) return ans
        }
        return ans

    }
}