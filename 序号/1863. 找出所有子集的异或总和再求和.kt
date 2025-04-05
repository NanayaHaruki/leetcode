class Solution {
    var n: Int = 0
    lateinit var ns: IntArray
    var ans = 0
    fun dfs(i: Int, x: Int) {
        if (i == n) {
            ans += x
            return
        }
        dfs(i + 1, x)
        dfs(i + 1, x xor ns[i])
    }

    fun subsetXORSum(_nums: IntArray): Int {
        n = _nums.size
        ns = _nums
        dfs(0, 0)
        return ans
    }

    // 数学方法
    // fun subsetXORSum(nums: IntArray): Int {
    //     return nums.fold(0){acc, i -> acc or i }.shl(nums.size-1)
    // }
}