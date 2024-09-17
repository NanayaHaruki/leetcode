class Solution {
    fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
        val n = routes.size
        if(source==target) return 0
        // 将每个车站属于哪些路线
        val dict = mutableMapOf<Int,ArrayDeque<Int>>()
        routes.forEachIndexed { i, route ->
            route.forEach {  s ->
                if (!dict.containsKey(s)) {
                    dict[s] = ArrayDeque<Int>().apply { add(i) }
                } else {
                    dict[s]!!.add(i)
                }
            }
        }
        val vis = BooleanArray(501)
        val q = ArrayDeque<Int>()

        // 起点不在路线中
        if(!dict.containsKey(source))return -1

        // 终点不在路线中
        if(!dict.containsKey(target)) return -1

        q.addAll(dict[source]!!)
        var ans = 0
        while(q.isNotEmpty()){
            ans++
            val sz = q.size
            for (i in 0 until sz){ // i 这个点属于哪些路线
                val routeIndex = q.removeFirst()
                for (j in routes[routeIndex]){ // j 这条路线有哪些其他点
                    if(j==target) return ans
                    for (k in dict[j]!!){ // k为j存在于哪些路线
                        if(!vis[k]){
                            q.add(k)
                            vis[k]=true
                        }
                    }

                }
            }
        }
        return -1
    }
}