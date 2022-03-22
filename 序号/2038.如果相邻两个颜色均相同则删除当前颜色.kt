class Solution {
	fun winnerOfGame(colors: String): Boolean {
		var (a, b) = 0 to 0
		for (i in 1 until colors.length-1) {
			if (colors[i] == 'A' && colors[i - 1] == 'A' && colors[i + 1] == 'A') {
				a++
			} else if (colors[i] == 'B' && colors[i - 1] == 'B' && colors[i + 1] == 'B') {
				b++
			}
		}
		return a > b
	}
}