class Solution {
    val ans = mutableListOf<List<Int>>()
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        // 已知graph是个DAG ，找0到n-1所有路线，直接遍历就好了，
        // 从0找起
        dfs(graph,0, LinkedList<Int>().apply { add(0) })
        return ans
    }

    /**
     * @param index 当前在哪个节点
     * @param list 是个临时容器，存储经过的节点 */
    fun dfs(graph:Array<IntArray>,index:Int,list:LinkedList<Int>){
        if (index==graph.size-1) {
            ans.add(ArrayList(list))
            return
        }

        for(i in graph[index]) {
            list.add(i) // 经过节点就加进去
            dfs(graph, i,list) // 到达终点后，ans会复制一个list
            list.removeLast() // 去除临时节点，走下一条路线
        }
    }
}