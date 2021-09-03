class Solution() {
    fun smallestK(arr: IntArray, k: Int): IntArray {
        /* 方法一 普通的排序
        arr.sort()
        val ans = IntArray(k)
        for (i in 0 until k) ans[i]=arr[i]
        return ans
        */

        // 方法二，大顶堆pq
        val pq = PriorityQueue<Int>(Collections.reverseOrder()) //pq 不能限制大小，当到达k的时候，需要弹出最大的
        for (num in arr){
            if (pq.size<k){
                pq.offer(num)
            }else {
                if (pq.isNotEmpty()) {
                    val max = pq.peek()
                    if (num < max){
                        pq.poll()
                        pq.offer(num)
                    }
                }
            }
        }
        return pq.toIntArray()
    }
}