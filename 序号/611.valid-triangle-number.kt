class Solution {
    fun triangleNumber(nums: IntArray): Int {
        // 两边之和大于第三边
        // 三条边三个指针，时间n^3,但经过排序
        nums.sort()
        if (nums.size<3) return 0
        var ans = 0
        for (i in 0..nums.size - 3) {
            for (j in i+1..nums.size - 2) {
                for (k in j+1..nums.size-1){
                    if (nums[i]+nums[j]>nums[k]) ans++ //两条短边大于长边
                    else break // 这个k都不满足的话，更长的边没必要计算了，nums排过序了
                }
            }
        }
        return ans
    }
}