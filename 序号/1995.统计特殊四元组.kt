fun countQuadruplets(nums: IntArray): Int {
    // 找3个数值和为第4个数  这个四元组的个数
    // 四指针
    var ans = 0
    for (i in 0 until nums.size - 3) {
        for (j in i+1 until nums.size-2){
            for (k in j+1 until nums.size-1){
                for (l in k+1 until nums.size){
                    if (nums[i] + nums[j] + nums[k] == nums[l]) {
                        ans++
                    }
                }
            }
        }
    }
    return ans
}