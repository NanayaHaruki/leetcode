import kotlin.math.sqrt

class Solution {
    fun bulbSwitch(n: Int): Int {
        // 灯初始状态是灭的，最终结果取决于被开了几次
        // 6会被 1 6 2 3 开4次，结果是偶数即灭
        // 4会被 1 4 2 开3次，结果是开
        // 问题转换为1～n有几个完全平方数
        return sqrt(n.toDouble()).toInt()
    }
}