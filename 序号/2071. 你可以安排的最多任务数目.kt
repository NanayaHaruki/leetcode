class Solution {
    fun maxTaskAssign(tasks: IntArray, workers: IntArray, pills: Int, strength: Int): Int {
        val n = tasks.size
        val m = workers.size
        tasks.sort()
        workers.sort()

        fun canCompleteTask(k:Int):Boolean{
            // 检查能否完成t个任务，用最强的t个人去完成最简单的t个任务
            // 将每个工人能完成的任务存起来
            val tsk = ArrayDeque<Int>()
            var tskId = 0
            var p = pills
            for (i in m-k until m){
                val w = workers[i]
                while (tskId<k && w+strength>=tasks[tskId]) {
                    tsk.add(tasks[tskId])
                    ++tskId
                }
                // tsk 存着前一个人嗑药能完成的任务（现在这个更强的当然更能完成） ，以及更强的能完成的新任务
                if(tsk.isEmpty()){ // 没任务
                    return false
                }
                if (w>=tsk.first()){ // 不嗑药就能干活，药省下来给需要的人
                    tsk.removeFirst()
                    continue
                }
                // 不嗑药没法干了
                if(p==0) return false
                // 嗑药，将最难的给干了
                p-=1
                tsk.removeLast()
            }
            return true
        }
        var l = 0
        var r = min(m,n)+1
        while(l+1<r){
            val mid = (l+r)/2
            if(canCompleteTask(mid)){
                l=mid
            }else{
                r=mid
            }
        }
        return l
    }
}