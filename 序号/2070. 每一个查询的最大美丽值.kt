class Solution {
    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        items.sortWith{ a,b->
             if(a[0]!=b[0]) a[0]-b[0] else b[1]-a[1]
        }
        val beautyDict = IntArray(items.size)
        var maxBeauty = 0
        items.forEachIndexed { idx,ints->
            if (ints[1]>maxBeauty) maxBeauty = ints[1]
            beautyDict[idx]=maxBeauty
        }
        val n = items.size
        val ans = IntArray(queries.size)
        queries.forEachIndexed { index, price -> 
            var l = -1
            var r = n
            while(l+1<r){
                val m = (l+r)/2
                if (items[m][0]>price){
                    r=m
                }else{
                    l=m
                }
            }
            ans[index] = if(l==-1) 0 else beautyDict[l]
        }
        return ans
    }
}