class Solution {
    /** 数组可以任意排序  元素可以减小  数组中相邻元素只能+-1  求数组变化后的最大值 */
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        // 排序后，遍历，一个个的降低，最后一个就是答案
        if (arr.size==1) return 1
        arr.sort()
        arr[0]=1
        for (i in 1..arr.lastIndex){
            if (arr[i] > arr[i - 1]) {
                arr[i]=arr[i-1]+1
            }
        }
        return arr.last()
    }
}