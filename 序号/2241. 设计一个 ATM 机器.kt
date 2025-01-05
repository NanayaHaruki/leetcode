class ATM() {
  var cnt = IntArray(5)
  val d = intArrayOf(20,50,100,200,500)
  fun deposit(banknotesCount: IntArray) {
      for(i in 0..4){
          cnt[i]+=banknotesCount[i]
      }
  }

  fun withdraw(amount: Int): IntArray {
                         val cost = IntArray(5)
      var remain = amount
      for(i in 4 downTo 0){
          if(cnt[i]==0) continue
          if(remain<d[i]) continue
          val curCnt = min(cnt[i],remain/d[i])
          cost[i]+=curCnt
          remain-=curCnt*d[i]
      }
      if(remain>0) {
          return intArrayOf(-1)
      } else {
          for(i in 0..4){
              cnt[i]-=cost[i]
          }
          return cost
      }
  }

}