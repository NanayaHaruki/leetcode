class Solution {
    lateinit var sortNum:IntArray
    lateinit var preSum:IntArray
    var k:Int = 0

    /** 给数组中数字加上k次，每次加1  让某个数出现次数最大 */
    fun maxFrequency(nums: IntArray, _k: Int): Int {
        // 排序后，在一个区间内[l,r]，让所有数变成最大的那个 就是r
        // 利用前缀和可以的出任意区间和，区间全部变成r的和为r*len，他们的差值如果小于k 就表示这个len可行
        // 利用二分，寻找最大的len

        k=_k
        // 先排序
        nums.sort()
        sortNum = nums
        // 计算前缀和
        preSum = IntArray(nums.size+1)
        for (i in nums.indices) preSum[i+1] = preSum[i]+nums[i]

        // 二分开始找len
        var l = 1
        var r = nums.size
        while(l<=r){
            val mid = l+(r-l)/2
            if (check(mid)) {
                l=mid+1
            }else {
                r=mid-1
            }
        }
        if (r<0|| !check(r)) return 1
        return r
    }

    fun check(len:Int):Boolean{
        for (i in 0 until preSum.size - len) {
            val sum = preSum[i+len]-preSum[i]
            if (sortNum[i+len-1]*len-sum <=k) return true
        }
        return false
    }
}