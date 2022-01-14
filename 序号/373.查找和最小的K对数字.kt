import java.util.*

class Solution {
    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        val pq = PriorityQueue<List<Int>>() { o1, o2 -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]] }
        for (i in 0 until minOf(nums1.size, k)) pq.offer(listOf(i, 0))
        val ans = mutableListOf<List<Int>>()
        for (i in 0 until k) {
            val (idx1, idx2) = pq.poll()
            ans.add(listOf(nums1[idx1], nums2[idx2]))
            if (idx2 < nums2.size - 1) {
                pq.offer(listOf(idx1, idx2 + 1))
            } else {
                if (pq.isEmpty()) {
                    break
                }
            }
        }
        return ans
    }
}