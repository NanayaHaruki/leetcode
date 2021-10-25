import java.util.HashMap;
import java.util.Map;
class Solution {
    /** --------------------   方法一   -----------------------
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        //这不就是个遍历二叉树吗
        return dfs(nums,0,0,target)
    }

    /**
     * @param index 遍历到哪一层了
     * @param curr 当前的和为多少
     * @return 触底了，有几种可能为target
     * */
    fun dfs(nums: IntArray, index: Int, curr: Int, target: Int): Int {
        if (index == nums.size) {
            return if (curr == target) 1 else 0
        }
        val left = dfs(nums, index + 1, curr + nums[index], target)
        val right = dfs(nums, index + 1, curr - nums[index], target)
        return left + right
    }
    --------------------------------------------------*/

    /**-----------------  方法二 记忆化DFS-------------------
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
    //这不就是个遍历二叉树吗
    return dfs(nums,0,0,target)
    }

    val map = mutableMapOf<String,Int>()
    fun dfs(nums: IntArray, index: Int, curr: Int, target: Int): Int {
    val key = "$index-$curr"
    if (map[key] !=null) return map[key]!!
    if (index == nums.size) {
    val value = if (curr == target) 1 else 0
    map[key]=value
    return value
    }
    val left = dfs(nums, index + 1, curr + nums[index], target)
    val right = dfs(nums, index + 1, curr - nums[index], target)
    map[key]=left+right
    return left + right
    }
     -----------------------------------------------------*/

    /**-------------------- DP --------------------------*/
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        //    取正数的数 和为x    取负数的数 和为y
        //     x+y=sum
        //     x-y=target
        //     2x=sum+target
        //     相当于从数组中挑出几个数，让他们的和为 (sum+target)/2 ,正负选择问题 变更为  选或不选的问题
        val sum = nums.sum()
        if (target > sum || (sum + target) % 2 == 1) return 0 // x不是整数，说明取不出来这情况，返回0
        val x = (sum + target) / 2
        //    定义数组dp[i][j] 用前面i个数，凑出j的可能性有几种
        //     dp[i][j]=dp[i-1][j]  前面i-1就凑出j了,这个数不拿
        //                 +dp[i-1][j-nums[i-1]]   前面i-1凑出了差值，加上这个
        //    有i-1的存在，i要从1开始
        //    base case 前面0个数 和为0的可能性为1,就是什么都不拿
        val dp = Array(nums.size + 1) { IntArray(x + 1) { 0 } }
        dp[0][0] = 1
        for (i in 1..nums.size) {
            for (j in 0..x) {
                dp[i][j] += dp[i - 1][j]
                if (j >= nums[i - 1]) dp[i][j] += dp[i - 1][j - nums[i - 1]]
            }
        }
        return dp[nums.size][x]
    }
}

