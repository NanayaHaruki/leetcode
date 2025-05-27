class Solution {
  fun differenceOfSums(n: Int, m: Int): Int {
      // ［1,n］无法被m整除的数之和 与 可以被m整除数的和 的差
      var sm = (1+n)*n/2
      val b = n/m*(1+n/m)/2*m
      return sm-b-b
  }
}