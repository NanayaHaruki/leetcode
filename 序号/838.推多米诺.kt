class Solution {
	fun pushDominoes(dominoes: String): String {
		// 多米诺倒的方向，返回最终。
		val arr = dominoes.toCharArray()
		val ans = CharArray(dominoes.length)

		// 每张站着的骨牌，都取决与左右两边的方向
		// 方向一致，则站着的也会导向那个方向；
		// 方向不一致，倒向中间则中间的站着，两边向中间倒。倒向两边，则全部站着
		val direction = intArrayOf(-1, -1, 0, 0) // 角标0 2 表示左右倒下的骨牌坐标； 角标1 3的值表示向哪倒，-1左 1 右
		var i = 0
		while (i < arr.size) {
			if (arr[i] == '.') {
				// 更新右节点
				var j = i + 1
				while (j < arr.size) {
					if (arr[j] != '.') break
					j++
				}
				if (j == arr.size) {
					for (k in i until j) ans[k] = if (direction[1] == -1) '.' else 'R'
					break
				} else {
					direction[2] = j
					direction[3] = if (arr[j] == 'L') -1 else 1
					// 左右同向
					if (direction[1] == direction[3]) {
						for (k in i..j) ans[k] = if (direction[1] == -1) 'L' else 'R'
						i = j + 1
						direction[0] = direction[2]
						direction[1] = direction[3]
					} else {
						// 向两边倒
						if (direction[1] == -1 && direction[3] == 1) {
							for (k in i until j) ans[k] = '.'
							ans[j] = if (direction[3] == -1) 'L' else 'R'
						} else {
							// 向中间倒
							var l = direction[0]
							var r = direction[2]
							while (l <= r) {
								if (l == r) ans[l] = '.'
								else {
									ans[l] = 'R'
									ans[r] = 'L'
								}
								l++
								r--
							}
						}
						direction[0] = direction[2]
						direction[1] = direction[3]
						i = direction[2] + 1
					}
				}
			} else {
				ans[i] = arr[i]
				// 更新左节点
				direction[0] = i
				direction[1] = if (arr[i] == 'L') -1 else 1
				i++
			}
		}
		return String(ans)
	}
}