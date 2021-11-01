class Solution {
    fun distributeCandies(candyType: IntArray): Int {
        // 数组中每个数字表示一种糖果，数量需要平分，返回最大种类数
        // 糖果数量小于等于数组长度一半的时候，可以获得最大种类数量
        // 糖果数量大于数组长度一半，最多只能拿一半，因为数量上需要两人平分
        val n = candyType.size
        val set = mutableSetOf<Int>()
        for (i in candyType) {
            set.add(i)
        }
        return if (set.size <= n/2) set.size else n / 2
    }
}