class Solution {
  fun minimumCost(m: Int, n: Int, horizontalCut: IntArray, verticalCut: IntArray): Long {
      // 切每一刀都会让另一个方向多切一次。不论方向先切消耗大的
      horizontalCut.sort()
      verticalCut.sort()
      var sumH = horizontalCut.sum()
      var sumV = verticalCut.sum()
      var ans = 0L
      var i = horizontalCut.lastIndex
      var j = verticalCut.lastIndex
      while(i>=0 || j>=0){
          if(i<0){
              ans+=sumV
              break
          }
          if(j<0){
              ans+=sumH
              break
          }
          if(horizontalCut[i]>verticalCut[j]){
              ans=ans+horizontalCut[i]+sumV
              sumH-=horizontalCut[i]
              i--
          }else{
              ans=ans+verticalCut[j]+sumH
              sumV-=verticalCut[j]
              j--
          }
      }
      return ans
  }
}