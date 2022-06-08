class Solution {
  fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
    // people[i][0] 为身高 people[i][1]为排在他前面比他高的人数，默认排序是错误的，返回正确的排序
    // 2个维度通常一个升序，一个降序，按身高降序，人头升序，后插入的时候，队列中全是比自己大的，必要按照人头数往队列位置插即可，等高的因为按升序排列，所以不会插在前面
    
    // 不知道为啥 lc用lamda编译不过
    // people.sortWith{o1:IntArray,o2:IntArray->
    //   val h1=o1[0];val k1=o1[1];val h2=o2[0];val k2=o2[1]
    //   if (h1==h2) k1-k2 else h1-h2
    // }
    people.sortWith(object:Comparator<IntArray>{
      override fun compare(o1: IntArray, o2: IntArray): Int {
        val h1=o1[0];val k1=o1[1];val h2=o2[0];val k2=o2[1]
        return if (h1==h2) k1-k2 else h2-h1
      }
    })
    val list = LinkedList<IntArray>()
    for (arr in people){
      if (arr[1]>=list.size) list.add(arr)
      else list.add(arr[1],arr)
    }
    return list.toTypedArray()
  }
}