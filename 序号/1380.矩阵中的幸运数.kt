class Solution {
	fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
		val ans = mutableListOf<Int>()
		// 找同行最小，同列最大的数
		val row = matrix.size
		val col = matrix.first().size
		var minColIndex = 0
		for (i in 0 until row) {
			for (j in 0 until col) {
				if (j == 0) minColIndex = 0
				else {
					if (matrix[i][j] < matrix[i][minColIndex]) {
						minColIndex = j
					}
				}
			}
			// 找完一行最小数，看他是不是所在列的最大
			var max = Int.MIN_VALUE
			for (k in 0 until row) {
				max = maxOf(max, matrix[k][minColIndex])
			}
			if (max == matrix[i][minColIndex]) ans.add(matrix[i][minColIndex])
		}
		return ans
	}
}