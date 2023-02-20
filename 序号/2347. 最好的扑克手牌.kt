class Solution {
  fun bestHand(ranks: IntArray, suits: CharArray): String {
    // 同花 三条 对子
    val ans = arrayOf("Flush","Three of a Kind","Pair","High Card")
    val suitSet = suits.toSet()
    if(suitSet.size==1) return ans[0]
    val d = mutableMapOf<Int,Int>()
    for(i in 0 until 5){
      d[ranks[i]]=d.getOrDefault(ranks[i], 0)+1
    }
    var maxCnt = 0
    for((_,cnt) in d){
      if(cnt>maxCnt){
        maxCnt=cnt
      }
    }
    return ans[4-minOf(3,maxCnt)]
  }
}