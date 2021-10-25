class Solution() {
    fun findMinMoves(machines: IntArray): Int {
        // 总共多少件，平均分配，不能平分返回-1,能平分，算出每个洗衣机最终应该有多少件
        // 遍历每个位置，计算要从当前位置左右移动多少次，求出移动最大次数即可
        val sum = machines.sum()
        val size = machines.size
        if (sum % size != 0) return -1
        val avarage = sum / size
        var l = 0
        var r = sum
        var ans = 0
        for (i in 0 until size) {
            r -= machines[i]
            // 当前位置，左边实际数量，小于应该有的衣服数量，那么应该从右边移动过来
            val r2l = if (l < avarage * i) {
                avarage * i - l
            } else {
                0
            }
            /* 不能这样，都以左边为参考，会漏掉当前项的转移，要同时考虑左右
            val l2r = if(l>avarage*i){
                l-avarage*i
            }else {
                0
            }
            */
            val l2r = if (r < avarage * (size - 1 - i)) {
                avarage * (size - 1 - i) - r
            } else {
                0
            }
            if (ans < l2r + r2l) {
                ans = l2r + r2l
            }
            l += machines[i]
        }
        return ans
    }
}