class Solution() {
    /**
     * @param k 最大项目数量
     * @param w 初创资本
     * @param profits 项目利润
     * @param capital 开启项目最小资本
     * @return 最多完成k项目后的最大资本
     * */
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        // 尝试贪心 每一步走利润最大的
        // 先对利润排序，寻找利润最大且当前资本可以运行的项目，结束点为k用完了，或项目用完了，或没有符合项目可以做了

        // key为利润 值为该利润所需最小资本  不同项目利润可能相同，所以是个list，资本按从小到大排列，先执行小资本大利润的项目
        val sortedMap = TreeMap<Int,PriorityQueue<Int>>(Collections.reverseOrder())
        for (i in profits.indices){
            val profit = profits[i]
            var pq = sortedMap[profit]
            if (pq==null){
                pq= PriorityQueue()
            }
            pq.offer(capital[i])
            sortedMap[profit]=pq
        }

        var maxProjects = k
        var money = w
        while (maxProjects>0 && sortedMap.isNotEmpty()){
            var findProject = false
            for ((profit, costQueue) in sortedMap){
                // 这个项目可以做，cost能cover
                if (costQueue.peek()<=money){
                    findProject=true
                    costQueue.poll()
                    money+= profit
                    maxProjects--
                    if (costQueue.isEmpty()) sortedMap.remove(profit)
                    break
                }
            }
            if (!findProject) break
        }
        return money
    }
}