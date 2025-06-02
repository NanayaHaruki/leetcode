class Solution {
    fun candy(ratings: IntArray): Int {
        // 遍历两遍，从左到右确保右边的比左边的大。 1 0 这种给两个都是1
        // 从右到左确保左边比右边大，1 0 这种可以正确分配成2 1
        val n = ratings.size
        val l = IntArray(n)
        val r = IntArray(n)
        l[0]=1
        r[n-1]=1
        var ans = 0
        for(i in 1 until n){
            if(ratings[i]>ratings[i-1]) l[i]=l[i-1]+1
            else l[i] =1
        }
        for(i in n-2 downTo 0){
            if(ratings[i]>ratings[i+1]) r[i]=r[i+1]+1
            else r[i]=1
        }
        return l.zip(r).sumOf{max(it.first,it.second)}
    }
}