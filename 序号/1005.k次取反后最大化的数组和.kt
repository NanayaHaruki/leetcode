fun largestSumAfterKNegations(nums: IntArray, k: Int): Int {
    // 每次转变，最小的负数转正，最小的正数转负，总和才最大
    // 都是要取小的进行变化，默认排序就行
    val posPQ = PriorityQueue<Int>()
    val negPQ = PriorityQueue<Int>()
    var sum = 0
    for (i in nums){
        if (i>=0) posPQ.add(i)
        else negPQ.add(i)
        sum+=i
    }
    for (i in 1..k){
        if (negPQ.isNotEmpty()) {
            val negNum = negPQ.poll()
            sum-=2*negNum
            posPQ.add(-negNum)
        }else{
            val posNum = posPQ.poll()
            sum-=2*posNum
            negPQ.add(-posNum)
        }
    }
    return sum
}