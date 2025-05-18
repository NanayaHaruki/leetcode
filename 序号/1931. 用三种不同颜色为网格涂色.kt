class Solution {
    fun colorTheGrid(m: Int, n: Int): Int {
        // 将每一列记成一个三进制数 ，预处理所有合法的三进制数
        val p3 = IntArray(m).apply{
            this[0]=1
            for(i in 1 until m) this[i]= this[i-1]*3
        }
        val colors = mutableListOf<Int>()
        X@ for(color in 0 until p3.last()*3){
            // color是一列合法的颜色，就是三进制相邻两位不能一样
            for(i in 1 until m){
                if(color / p3[i-1] % 3 == color / p3[i] % 3) continue@X
            }
            colors.add(color)
        }
        // 计算每一列的相邻可以是哪些其他合法列，即合法三进制,color计算时排除了上下不能同色相邻
        // 这里计算左右不能同色相邻
        val nxt = Array(colors.size){ mutableListOf<Int>() }
        colors.forEachIndexed { i, c1 ->
            colors.forEachIndexed { j, c2 ->
                var isValid = true
                p3.forEach { p->
                    if(c1 / p % 3 == c2 / p % 3) {
                        isValid=false
                        return@forEach
                    }
                }
                if(isValid) nxt[i].add(j)
            }
            
        }
        val mod = 1_000_000_007
        val f = Array(n){IntArray(colors.size)} // 每一列为某个color的可能性
        for(i in colors.indices) f[0][i]=1 //第1列，所有可能性都可以
        for(i in 1 until n){
            for (j in colors.indices){ // 第i列放c
                for(k in nxt[j]){ // 与colors[j]相邻的所有可能性加起来，就是在i可以放colors[j]的数量
                    f[i][j] = (f[i][j]+f[i-1][k] ) % mod
                }
            }
        }
        return (f.last().sumOf { it.toLong() } % mod).toInt()
    }
}