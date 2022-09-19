class Solution {
  /** 按频率升序 频率相同按大小降序 */
  fun frequencySort(nums: IntArray): IntArray {
    val d = sortedMapOf<Int,PriorityQueue<Int>>()
    val cntDict = mutableMapOf<Int,Int>()
    val cmp = Comparator<Int>{i,j-> j-i}
    for (num in  nums){
      cntDict[num]=cntDict.getOrDefault(num,0)+1
    }
    for ((num,cnt) in cntDict){
      val pq = d.getOrDefault(cnt,PriorityQueue<Int>(cmp))
      pq.offer(num)
      d[cnt]=pq
    }
    var i = 0;val it = d.iterator()
    while (it.hasNext()){
      
      val (cnt,pq) = it.next()
      while (pq.isNotEmpty()){
        val num = pq.poll()
        for (j in 0 until cnt) {
          nums[i++] =num
        }
      }
    }
    return nums
  }
}