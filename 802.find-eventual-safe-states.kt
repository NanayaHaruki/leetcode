class Solution {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        // graph表示从索引到intArray中的单向，要求返回所有路线都无环的节点
        // 有向无环图可以通过拓扑排序求解，根据题意，画出反向图，再拓扑排序即为所求dGraph = {List[7]@775} 节点，因为这些节点不会经过环

        // 索引对应的list为反向图中的指向节点，每个点的出度就是list的长度
        val dGraph = Array<MutableList<Int>>(graph.size){ mutableListOf()}
        val inCntArr = IntArray(graph.size) // 记录反向图每个点的入度
        for (i in graph.indices) {
            val arr = graph[i]
            for (j in arr){
                dGraph[j].add(i)
                inCntArr[i]++
            }
        }

        val ans = mutableListOf<Int>()
        val queue = ArrayDeque<Int>()
        for (i in inCntArr.indices) {
            if (inCntArr[i]==0) queue.add(i)
        }
        while (queue.isNotEmpty()) {
            val i = queue.removeFirst()
            ans.add(i)
            for (j in dGraph[i]) {
                inCntArr[j]-- // 入度降低,为0了进队列
                if (inCntArr[j]==0) queue.addLast(j)
            }
        }
        ans.sort()
        return ans
    }
}