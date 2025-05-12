class Solution {
  fun findEvenNumbers(digits: IntArray): IntArray {
      val n = digits.size
      val ans = TreeSet<Int>()
      val cnts = IntArray(10)
      for(d in digits)  cnts[d]++
      for(k in 0..8 step 2){
          if(cnts[k]==0) continue
          cnts[k]--
          for(i in 0..9){
              if(cnts[i]==0) continue
              cnts[i]--
              for(j in 0..9){
                  if(cnts[j]==0) continue
                  if(i!=0) ans.add(i*100+j*10+k)
                  if(j!=0) ans.add(j*100+i*10+k)
              }
              cnts[i]++
          }
          cnts[k]++
      }
      return ans.toIntArray()

  }
}