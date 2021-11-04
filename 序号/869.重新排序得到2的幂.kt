class Solution {
    // set中存着所有2的幂
    private val set = mutableSetOf<Int>().apply {
        add(1)
        var x = 1
        for (i in 1..30) {
            x *= 2
            add(x)
        }
    }

    fun reorderedPowerOf2(n: Int): Boolean {
        val len = n.toString().length
        out@ for (i in set) {
            if (i.toString().length == len) {
                val dict = mutableMapOf<Int, Int>()
                // 对比数字的数量是否相同
                var j = i
                while (j > 0) {
                    val mod = j % 10
                    dict[mod] = (dict.getOrDefault(mod, 0)) + 1
                    j /= 10
                }

                var m = n
                while (m > 0) {
                    val mod = m % 10
                    val modCnt = dict[mod]
                    // 不能直接返回false，位数相同的有很多 比如 16 32 64.最小路径和.kt 或者1 2 4 8
                    if (modCnt == null) continue@out
                    else {
                        if(modCnt==1) dict.remove(mod)
                        else dict[mod] = dict[mod]!! - 1
                    }
                    m /= 10
                }
                return true
            } else if (i.toString().length > len) break //  位数大了，不用查了

        }
        return false
    }
}