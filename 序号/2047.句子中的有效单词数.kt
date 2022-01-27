class Solution {
	val signArr = charArrayOf('!', '.', ',')
	fun countValidWords(sentence: String): Int {
		// 用空格分割，
		// 不含数字；-只有一个且两边是字母；最多一个标点且在末尾
		val words = sentence.split(" ")
		var linkCnt = 0// 连接字符个数
		var ans = 0
		word@ for (word in words) {
			if (word.isEmpty()) continue
			linkCnt=0
			for (i in word.indices) {
				val c = word[i]
				when {
					c.isDigit() -> continue@word
					c == '-' -> {
						if (linkCnt > 0) continue@word
						else {
							linkCnt = 1

							if (i == 0 || i == word.length - 1
								|| !word[i - 1].isLowerCase()
								|| !word[i + 1].isLowerCase()
							) continue@word
						}
					}
					c in signArr -> {
						if (i != word.length - 1) continue@word
					}
				}
			}
			ans++
		}
		return ans
	}
}