private lateinit var ages:IntArray
private var ans = 0
fun numFriendRequests(_ages: IntArray): Int {
    // 比我小或同龄人，且比我一半+7大的人 发消息
    // 先排序，计算当前人前面的 就是比我小的（需要指针移动到同龄的最右，因为要给同龄人发消息），
    // 再二分寻找0.5x+7所在角标，一减就是需要发多少消息。
    _ages.sort()
    ages = _ages
    for (i in ages.indices){
        calcMsg(i)
    }
    return ans
}

private fun calcMsg(_i:Int){
    var i= _i
    while (i+1<ages.size && ages[i+1]==ages[i]){
        i+=1
    }
    var l = 0
    var r = i
    while (l<=r) {
        val m = l + (r - l) / 2
        val limit = (ages[i]*0.5+7).toInt()
        when {
            ages[m]>limit ->{
                r=m-1
            }
            ages[m]<limit->{
                l=m+1
            }
            ages[m]==limit->{
                l=m+1
            }
        }
    }
    ans+= maxOf(0,(i- l))

}