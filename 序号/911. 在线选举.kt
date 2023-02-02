class TopVotedCandidate(persons: IntArray, times: IntArray) {
  private val tree = TreeMap<Int,Int>()
  init{
    val n = times.size
    var max=0
    val votes = IntArray(n)
    for(i in times.indices){
      val time = times[i]
      val person = persons[i]
      votes[person]++
      if (votes[person]>=votes[max]){
        max=person // 票数相同，最近的票的优先
      }
      tree[time]=max
    }

  }
  /** 在t时刻领先的person */
  fun q(t: Int): Int {
    val e = tree.floorEntry(t)
    if(e.key==t) return e.value
    return tree.lowerEntry(t)!!.value
  }
}