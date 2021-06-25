class Solution {
    fun openLock(deadends: Array<String>, target: String): Int {
        // bfs 用个queue存储每一步的可能性，直到找到target，遇到dead就跳过
        // 用数组判断当前状态，每次都要遍历，时间复杂度过高，用hashset存起来
        val deadSet = deadends.toSet()
        if (target == "0000") return 0
        if (deadSet.contains("0000")) return -1
        val queue = LinkedList<String>()
        queue.add("0000")
        val seen = mutableSetOf<String>()
        seen.add("0000")
        var step = 0
        while (queue.isNotEmpty()) {
            step++ //转一次
            // 把转一次的状态全部遍历，不能用queue.isNotEmpty了
            // 因为在不断往里面塞。继续下当前size，就遍历几次
            for (i in queue.indices) {
                for (status in step(queue.removeFirst())) {
                    // 没找到，继续走step，继续转，走下一次循环
                    if (!deadSet.contains(status) && !seen.contains(status)) {
                        if (status == target) return step // 找到了直接返回
                        queue.addLast(status)
                        seen.add(status)
                    }
                }
            }
        }
        return -1
    }

    fun step(cur: String): Array<String> {
        val curCharArr = cur.toCharArray()
        val res = Array<String>(8) { "" }
        // 转一次会变成啥，密码锁四位，每位往前往后 共8种情况
        for (i in 0..3) {
            val curChar = curCharArr[i]
            // 往前转
            val preChar = if (curChar == '0') '9'
            else curChar - 1
            // 往后转
            val posChar = if (curChar == '9') '0'
            else curChar + 1
            // 改变当前char，分别存起来
            curCharArr[i] = preChar
            res[2 * i] = String(curCharArr)
            curCharArr[i] = posChar
            res[2 * i + 1] = String(curCharArr)
            // 变回去，不影响后面循环
            curCharArr[i] = curChar
        }
        return res
    }
}