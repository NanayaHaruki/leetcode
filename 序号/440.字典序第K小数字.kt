class Solution {
	fun findKthNumber(n: Int, _k: Int): Int {
		// 1-n 字典序 找到第k个数
		// 十叉树  1的子结点 10~19  10的子结点 101～109,统计子树数量，找到第k个。n决定了数的高度
		// 找前缀 检查是不是1开头的  不是找2；是1开头的，是不是10开头的，不是找11.
		var k = _k
		var ans = 1
		while (k > 1) {
			val cnt = check(ans, n)
			if (cnt >= k) {
				// 答案就在当前ans这个前缀里
				ans *= 10 // 从这个前缀+0开始继续查子树
				k-- // -1表示前缀本身,如果减完k=1，则跳出循环当前ans这个前缀就是答案；
			} else {
				ans++
				k -= cnt
			}
		}
		return ans
	}

	/** <=n的数中 以pre开头的数有多少个 */
	fun check(pre: Int, n: Int): Int {
		// 200 以1的数 有1 10-19 100-199
		var ans = 0
		var first = pre.toLong()
		var last = pre.toLong()
		while (first <= n) {
			ans += (minOf(n.toLong(), last) - first + 1).toInt()
			first *= 10
			last = last * 10 + 9
		}
		return ans
	}
}