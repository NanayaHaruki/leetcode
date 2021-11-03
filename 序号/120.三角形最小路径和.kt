
fun minimumTotal(triangle: List<MutableList<Int>>): Int {
    for (i in 1 until triangle.size){
        // 三角形和方形不一样，路线只能索引相同，
        for (j in triangle[i].indices){
            triangle[i][j] += minOf(
                triangle[i-1].getOrNull(j-1)?:Int.MAX_VALUE,
                triangle[i-1].getOrNull(j)?:Int.MAX_VALUE
            )
        }
    }
    return triangle.last().minOrNull()!!
}