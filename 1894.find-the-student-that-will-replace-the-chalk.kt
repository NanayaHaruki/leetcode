class Solution() {
    /** 前缀和 */
    fun chalkReplacer(chalk: IntArray, k: Int): Int {
        val n = chalk.size
        // 因为k远大于chalk[i]，用前缀和算出需要转几圈，再数，可将时间从10^9 降到10^5*2
        val pre = LongArray(n)
        pre[0]=chalk[0].toLong()
        for (i in 1 until n){
            pre[i]=pre[i-1]+chalk[i]
        }
        // total是跑一圈消耗的粉笔数量
        val total = pre[n-1]
        // 模出来，算模在一圈的第几个消耗完就行了，不需要跑10^9次了
        val mod = k%total
        var ans = 0
        for (i in pre.indices){
            if (mod<pre[i]){
                ans = i
                break
            }
        }
        return ans
    }
    /*
    fun chalkReplacer(chalk: IntArray, k: Int): Int {
        var sum = k
        var index = 0
        while (true){
            sum-=chalk[index]
            if (sum<0) break
            index++
            if (index==chalk.size) index = 0
        }
        return index
    }*/
}