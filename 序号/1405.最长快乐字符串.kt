import java.util.*

class Solution {
	private var pq = PriorityQueue<Pair<Int, Char>>(kotlin.Comparator { t1, t2 ->
		return@Comparator t2.first - t1.first
	})

	fun longestDiverseString(_a: Int, _b: Int, _c: Int): String {
		// 每次找剩余最多的，最多用掉2个，用第2少的隔开，重复拼接
		if (_a > 0) pq.offer(_a to 'a')
		if (_b > 0) pq.offer(_b to 'b')
		if (_c > 0) pq.offer(_c to 'c')
		val sb = StringBuilder()
		while (pq.size > 0) {
			val (cnt1, char1) = pq.poll()
			if (pq.size == 0 && sb.length>=2 && sb[sb.length-2]==char1 &&  sb.last() == char1) break
			if (sb.length<=1 || sb.last() != char1 ||  sb[sb.length - 2] != char1) {
				sb.append(char1)
				if (cnt1 > 1) pq.offer(cnt1 - 1 to char1)
			} else {
				if (pq.isNotEmpty()) {
					val (cnt2, char2) = pq.poll()
					sb.append(char2)
					pq.offer(cnt1 to char1)
					if (cnt2 > 1) pq.offer(cnt2 - 1 to char2)
				}
			}

		}
		return sb.toString()
	}
}