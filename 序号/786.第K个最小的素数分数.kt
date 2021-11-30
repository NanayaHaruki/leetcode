/** 方法一 暴搜
fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
    // 素数集中找arr[i]/arr[j]  第k个大的分数
    // 数据量10^3^2 ,暴搜一波
    val sortedAns = sortedMapOf<Double, Pair<Int, Int>>()
    for (i in 0..arr.size - 2) {
        for (j in i + 1..arr.size - 1) {
            sortedAns[arr[i] / arr[j].toDouble()] = arr[i] to arr[j]
        }
    }
    var x = 1
    val it = sortedAns.iterator()
    while (x < k) {
        it.next()
        x++
    }
    val (i, j) = it.next().value
    return intArrayOf(i, j)

}
*/

fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
    // arr单调递增，用pq存k个值，0/j  1/j  2/j  j-1/j 也单调递增
    // 遍历以j为分母的时候，大于堆顶的就继续找j+1
    val pq = PriorityQueue<IntArray>() { arr1, arr2 ->
        (arr2[0].toDouble() / arr2[1]).compareTo(arr1[0].toDouble() / arr1[1])
    }
    val n = arr.size
    for (j in 1 until n) {
        for (i in 0 until j) {
            if (pq.size < k) {
                pq.offer(intArrayOf(arr[i], arr[j]))
            } else {
                val peek = pq.peek().run { get(0).toDouble() / get(1) }
                val cur = arr[i].toDouble() / arr[j]
                // cur的小，拿得移除peek，把cur塞进去
                if (cur < peek) {
                    pq.poll()
                    pq.offer(intArrayOf(arr[i], arr[j]))
                }
            }
        }
    }

    return pq.poll()
}

