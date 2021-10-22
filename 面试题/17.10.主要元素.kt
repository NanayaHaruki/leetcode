fun majorityElement(nums: IntArray): Int {
    val n = nums.size
    var cnt = 0
    var x = -1
    for(i in nums){
        if(cnt == 0) x = i
        if(x==i) cnt++
        else cnt--
    }
    cnt = 0
    for(i in nums){
        if(x==i) cnt++
    }
    return if(cnt>n/2) x else -1
}