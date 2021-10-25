import kotlin.math.abs
fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    // 在arr中找最靠近x的k个数  距离相同，优先加入小的
    // 先在arr中二分找到左边界
    var l = 0
    var r = arr.lastIndex
    while (l <= r) {
        val m = l + (r - l) / 2
        if (arr[m] < x) {
            l = m + 1
        } else {
            r = m - 1
        }
    }
    val nearestIndex = if (l > arr.lastIndex) r
    else if (r < 0) l
    else {
        if (abs(arr[l] - x) < abs(arr[r] - x)) {
            l
        } else {
            // 相等返回小的， r比较小
            r
        }
    }
    if (k == 1) return listOf(arr[nearestIndex])
    var nearLeft = nearestIndex
    var nearRight = nearestIndex
    // 从最接近x的地方开始找
    for (i in 2..k) {
        // 双指针向外扩，对比绝对值
        if (nearLeft - 1 < 0) {
            nearRight++
        } else if (nearRight == arr.lastIndex) {
            nearLeft--
        } else {
            if (abs(arr[nearLeft-1] - x) <= abs(arr[nearRight+1] - x)) {
                nearLeft--
            } else {
                nearRight++
            }
        }
    }
    val ans = mutableListOf<Int>()
    for (i in nearLeft..nearRight) {
        ans.add(arr[i])
    }
    return ans
}bs