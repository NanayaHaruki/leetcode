fun stoneGameIX(stones: IntArray): Boolean {
    val cnts = IntArray(3)
    for (stone in stones) cnts[stone%3]++
    return if (cnts[0]%2==0){
        !(cnts[1]==0||cnts[2]==0)
    }else {
        kotlin.math.abs(cnts[1] - cnts[2]) > 2
    }
}