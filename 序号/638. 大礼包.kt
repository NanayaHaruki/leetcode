class Solution {
    fun shoppingOffers(price: List<Int>, special: List<List<Int>>, needs: List<Int>): Int {
        // 把单买当作只有那个商品的大礼包考虑
        val packs =special.toMutableList()
        val n = price.size
        price.forEachIndexed { index, p ->
            val newPack = MutableList(n+1){0}
            newPack[index]=1
            newPack[n]=p
            packs.add(newPack.toList())
        }
        // 避免dfs中重复计算，先算下每个礼包能拿几个
        val dict = mutableMapOf<Int,Int>()
        packs.forEachIndexed { index, pack ->
            var cnt = Int.MAX_VALUE
            for (i in 0 until n){
                val a = pack[i] // 礼包里有a个
                val b = needs[i] // 需要b个
                if(a==0) continue // a=0,这个礼包拿多少个都不会超;
                cnt = min(cnt,b/a)
            }
            dict[index]=cnt
        }
        var ans = Int.MAX_VALUE
        /** 选第i个礼包，还要选remains个商品，前面总共花了curPrice的钱 */
        fun dfs(i:Int,remains:MutableList<Int>,curPrice:Int){
            if(curPrice>ans) return
            if (remains.sum()==0) {
                ans=curPrice
                return
            }
            if (i==packs.size) return
            val pack = packs[i]
            for(k in 0 .. dict[i]!!) { // k为拿几个这个礼包
                val newRemains = remains.toMutableList()
                for (j in 0 until n) {
                    val a = pack[j] // 礼包里a个
                    val b = remains[j] // 还要b个
                    if(a*k>b) {
                        return
                    }
                    newRemains[j]-=a*k
                }
                // 没return，说明拿k个可以，往后拿其他礼包
                dfs(i+1,newRemains,curPrice+pack[n]*k)
            }
        }
        dfs(0,needs.toMutableList(),0)
        return ans
    }
}