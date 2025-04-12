class Solution {
    fun countGoodIntegers(n: Int, k: Int): Long {
        val fac = IntArray(n+1) // 记录阶乘，用于后面计算排列数
        fac[0]=1
        for(i in 1..n){
            fac[i]=fac[i-1]*i
        }
        val vis = mutableSetOf<String>()
        val b = 10.0.pow((n-1)/2).toInt()
        var ans = 0L
        for (i in b until b*10){
            var s = i.toString()
            // 偶数从0开始   12反转成21，将21拼上去变成1221
            // 奇数从1开始  123反转321，截取21拼上去 12321
            s += s.reversed().substring(n%2)
            if(s.toLong() % k.toLong() >0) continue

            // 去重
            val sortS = String(s.toCharArray().apply { sort() })
            if(vis.contains(sortS)) continue
            vis.add(sortS)

            // 现在s为满足条件的，计算组合的可能性，第1位不能是0，有n-cnt0种可能，后面有(n-1)!种可能
            val cnts = IntArray(10)
            for(c in sortS){
                cnts[c-'0']=cnts[c-'0']+1
            }
            var a = (n-cnts[0])*fac[n-1]
            // 有数字重复的要继续去重
            for (cnt in cnts){
                a /= fac[cnt]
            }
            ans+=a
        }
        return ans
    }
}