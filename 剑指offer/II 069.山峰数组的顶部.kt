fun peakIndexInMountainArray(arr: IntArray): Int {
    var l = 0
    var r = arr.lastIndex
    while (l <= r) {
        val m = l + (r - l) / 2
        if (arr[m + 1] < arr[m]) {
            r = m - 1
        } else if (arr[m + 1] > arr[m]) {
            l = m + 1
        }
    }
    // arr在target两边满足单调性，不用判断l r的越界
    return l
}