class Solution {
  fun getLeastNumbers(arr: IntArray, k: Int): IntArray {
    if (k==0) return IntArray(0)
    val ans = IntArray(k)
    val pq = PriorityQueue<Int>(k
    ) { o1:Int, o2:Int ->  o2-o1 }
    for (i in arr){
      if(pq.size<k) pq.offer(i)
      else {
        val last = pq.peek()
        if (i < last) {
          pq.poll()
          pq.offer(i)
        }
      }
    }
    for(i in 0 until k){
      ans[i]=pq.poll()
    }
    return  ans
  }
}