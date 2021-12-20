fun findRadius(houses: IntArray, heaters: IntArray): Int {
    // 加热器  房屋位置 返回最小加热距离
    // 给加热器排序，用二分查找离房子最近的加热器是哪个，得出距离；遍历房子集合，不断更新距离
    heaters.sort()
    var ans = 0
    val n = heaters.size
    for (house in houses) {
        val i = Arrays.binarySearch(heaters, house)
        if (i >= 0) {
            // 加热器和房子重合，不需要更新半径
        } else {
            val l = -(i + 1) //找不到 l是超过的角标 要判断下是否越界以及跳过的角标和前一个角标谁比heater更近
            when {
                // 房子在所有加热器右边，用最右加热器计算
                l >= n -> {
                    ans = maxOf(ans, house - heaters[n - 1])
                }
                // 房子在所有加热器左边，用第一个加热器计算
                l == 0 -> {
                    ans = maxOf(ans, heaters[0] - house)
                }
                // 房子在俩加热器中间，找较近的那个
                else -> {
                    ans = maxOf(ans, minOf(heaters[l] - house, house - heaters[l - 1]))
                }
            }

        }
    }
    return ans
}