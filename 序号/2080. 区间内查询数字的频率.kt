class RangeFreqQuery(arr: IntArray) {

    val d  = mutableMapOf<Int,MutableList<Int>>()
    init{
        arr.forEachIndexed{i,x->
            if(d.contains(x)){
                d[x]!!.add(i)
            }else{
                d[x] =  mutableListOf(i)
            }
        }
    }
    fun query(left: Int, right: Int, value: Int): Int {
        if(!d.contains(value)) return 0
        val indecies = d[value]!!
        var l = -1
        var r = indecies.size
        while(l+1<r){
            val m = (l+r)/2
            if(indecies[m]<left){
                l=m
            }else{
                r=m // 找左边界 等于，也缩小右边
            }
        }
        // r是第1个大于等于left的
        var start = r
        l=-1
        r=indecies.size
        while(l+1<r){
            val m = (l+r)/2
            if(indecies[m]<=right){
                l=m
            }else{
                r=m
            }
        }
        return l-start+1
    }

}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * var obj = RangeFreqQuery(arr)
 * var param_1 = obj.query(left,right,value)
 */