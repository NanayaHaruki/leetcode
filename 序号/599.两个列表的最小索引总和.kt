class Solution {
	fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
		// 找俩数组中相同元素最小的索引和
		// 最少也要O（m+n)
		val ans = mutableListOf<String>()
		var minIndexSum = -1
		val dict = mutableMapOf<String, Int>()
		list1.forEachIndexed { index, s ->
			if (!dict.containsKey(s)) dict[s] = index
		}
		list2.forEachIndexed { index, s ->
			if (dict.containsKey(s)) {
				when {
					minIndexSum == -1 -> {
						minIndexSum = index + dict[s]!!
						ans.add(s)
					}
					index + dict[s]!! == minIndexSum -> {
						ans.add(s)
					}
					index + dict[s]!! < minIndexSum -> {
						minIndexSum = index + dict[s]!!
						ans.clear() // 有更小的，需要清空被选答案
						ans.add(s)
					}
				}
			}
		}
		return ans.toTypedArray()
	}
}