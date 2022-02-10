class Solution {
	fun simplifiedFractions(n: Int): List<String> {
		// 返回分母<=n的最简分数
		// 遍历1..n 作为分母i，遍历1..i-1 作为分子j，分母对分子取模，为0则简化后加进集合中，放入set防止重复
		val ans = mutableSetOf<String>()
		for (i in 1..n) {
			for (j in 1 until i) {
				// 化简，不断除以两数的最大公约数，直到最大公约数为1
				// 欧几里德辗转相除法
				ans.add(operator(i, j))
			}
		}
		return ans.toList()
	}

	private fun operator(_a: Int, _b: Int): String {
		var a = _a
		var b = _b
		while (true) {
			val mod = a % b
			if (mod == 0) break
			a = b
			b = mod
		}
		// 最大公约数为b
		return if (b == 1) {
			"$_b/$_a"
		} else {
			operator(_a / b, _b / b)
		}
	}
}