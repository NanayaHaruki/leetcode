class Solution {
	/** n*n  点亮lamps位置  queries取消当前点九宫格灯  返回结果 */
	fun gridIllumination(n: Int, lamps: Array<IntArray>, queries: Array<IntArray>): IntArray {
		// 用4个map记录横纵对角线，横纵key为坐标
		// 对角线key为映射到x轴的位置，映射位置相同就是同一条线，2,1 映射为1,0
		val rowDict = mutableMapOf<Int, Int>()
		val colDict = mutableMapOf<Int, Int>()
		val leftDict = mutableMapOf<Int, Int>()
		val rightDict = mutableMapOf<Int, Int>()
		val set = mutableSetOf<Int>()
		val ans = IntArray(queries.size)
		for ((row, col) in lamps) {
			// 添加成功了，再添加光线，重复的灯只能添加一次
			if (set.add(row * n + col)) {
				rowDict[row] = rowDict.getOrDefault(row, 0) + 1
				colDict[col] = colDict.getOrDefault(col, 0) + 1
				leftDict[col - row] = leftDict.getOrDefault(col - row, 0) + 1
				rightDict[row + col] = rightDict.getOrDefault(row + col, 0) + 1
			}
		}
		for (i in queries.indices) {
			val x = queries[i][0]
			val y = queries[i][1]
			// 检查光线，更新答案
			if (rowDict.containsKey(x) || colDict.containsKey(y)
				|| leftDict.containsKey(y - x) || rightDict.containsKey(y + x)
			) {
				ans[i] = 1
			}
			for (j in -1..1) {
				for (k in -1..1) {
					val row = x + j
					val col = y + k
					if (row in 0 until n && col in 0 until n) {
						// 灭灯
						if (set.contains(row * n + col)) {
							set.remove(row * n + col)
							// 灭光线
							rowDict[row]?.let {
								if (it == 1) rowDict.remove(row)
								else rowDict[row] = it - 1
							}
							colDict[col]?.let {
								if (it == 1) colDict.remove(col)
								else colDict[col] = it - 1
							}
							leftDict[col - row]?.let {
								if (it == 1) leftDict.remove(col - row)
								else leftDict[col - row] = it - 1
							}
							rightDict[col + row]?.let {
								if (it == 1) rightDict.remove(col + row)
								else rightDict[col + row] = it - 1
							}
						}

					}
				}
			}
		}
		return ans
	}
}