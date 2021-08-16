class Solution {
    lateinit var match: Array<MutableList<Int>>
    var ans = 0
    var N: Int = 0
    val used = BooleanArray(16)
    fun countArrangement(n: Int): Int {
        // 由[1,n]组成数组 ，使nums[i] % i == 0 || i%nums[i]==0,问多少种数组
        // 动规和回溯都能做，回溯先
        // 先构造可能在每个索引上的数字的集合，然后回溯计算种类
        N = n
        match = Array(n+1){ mutableListOf()}
        for (i in 1..n) {
            for (j in 1..n) {
                if (i % j == 0 || j % i == 0) match[i].add(j)
            }
        }
        backTrace(1)
        return ans
    }

    /** 往index位置插入数 */
    fun backTrace(index: Int) {
        // 数到最后一个数了，返回
        if (index == N + 1) {
            ans++
            return
        }

        // num为符合条件的数
        for (num in match[index]) {
            if (!used[num]) {
                used[num] = true
                backTrace(index + 1)
                used[num] = false
            }
        }
    }
}