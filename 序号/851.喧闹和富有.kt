class Solution {
    fun loudAndRich(richer: Array<IntArray>, quiet: IntArray): IntArray {
        // 财富：richer[i][0]>richer[i][1] 求ans[i],在财富>=i的人中，找最安静的人
        // 最富的人为k 则ans[k]=k,没有比他更富的人了，比它富且最安静的人就是它自己，根据这个值不断更新其他人

        // 搞个队列，存当前最富的人，用这个值的安静度取更新比他穷的人的ans
        // 如果富人满足财富比穷人多，又比穷人安静，就是这个穷人的候选答案，不断更新成更小的即可

        // 因为需要将不断用富人的安静值取比对穷人，所以需要对富人排序，可题目没有给出财富值，用图的入度来表达。
        // 入度为0,则该人为当前最富的，入度在遍历的时候递减，比它富的人遍历完了，它的入度就-1
        val n = quiet.size
        val ans = IntArray(n) // 默认比i富的最安静的人为自己
        // 建图，graph[i]得到的list，为比i穷的人
        val graph = Array<MutableList<Int>>(n){ mutableListOf()}
        val inDegree = IntArray(n)
        for ((rich,poor) in richer){
            graph[rich].add(poor)
            inDegree[poor]++ //穷人的入度+1,表达比它富的有几个人
        }

        val queue = ArrayDeque<Int>()
        for (i in 0 until n){
            ans[i]=i
            if (inDegree[i]==0) queue.offer(i)
        }

        while (queue.isNotEmpty()){
            // 当前最富的人
            val curRicher = queue.poll()
            // 比curRicher比它穷的人
            val poorList = graph[curRicher]
            for (poor in poorList){
                if (quiet[ans[curRicher]] < quiet[ans[poor]]) {
                    ans[poor]=ans[curRicher]
                }
                inDegree[poor]--
                if (inDegree[poor]==0){
                    queue.offer(poor)
                }
            }
        }
        return ans
    }
}