fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    // 找相同元素且索引<=k
    // 遍历nums时搞个set存放k个元素，往里塞不进去就说明前面有重复的，返回true即可
    val set = mutableSetOf<Int>()
    for (i in nums.indices){
        val n = nums[i]
        if (set.size<k){
            if (!set.add(n)) return true
        }
        else {
            if (!set.add(n)) return true
            else {
                set.remove(nums[i-k])
            }

        }
    }
    return false
}