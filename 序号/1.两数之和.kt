fun twoSum(nums: IntArray, target: Int): IntArray {
    // 枚举就不写了
    // 遍历的时候，看之前有没有出现过，有就直接返回，没有加进字典
    val dict = mutableMapOf<Int,Int>()
    for (i in nums.indices){
        val otherNum = target-nums[i]
        val j = dict.getOrDefault(otherNum,-1)
        if (j!=-1){
            return intArrayOf(i,j)
        }else {
            dict[nums[i]]=i
        }
    }
    return intArrayOf()
}