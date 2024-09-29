class Solution {
  fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
      var t = tickets[k] // 要买t张
      var ans = 0 // 自己买就需要t秒

      for(i in 0 until tickets.size){
          if(i<k){
              if(tickets[i]>=t){
                  ans+=t
              }else{
                  ans+=tickets[i]
              }
          }else if(i>k){
              if(tickets[i]>=t-1){
                  ans+=t-1
              }else{
                  ans+=tickets[i]
              }
          }else{
              ans+=t
          }
      }
      return ans
  }
}