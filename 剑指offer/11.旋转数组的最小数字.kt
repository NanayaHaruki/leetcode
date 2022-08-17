class Solution {
  fun minArray(numbers: IntArray): Int {
    var l = 0;var r = numbers.size-1
    // 要找的数位置在m，[m,r)所有数都比r小
    while(l<=r){
      val m = (l+r)/2
      if(numbers[m]<numbers[r]) r=m
      else if(numbers[m]==numbers[r]) r--
      else l=m+1
    }
    return numbers[l]
  }
}