class Solution {
  fun canWinNim(n: Int): Boolean {
      // n = k(m+1)+r ,r!=0时先手必胜，拿走r即可。 r==0,后手必胜，保证每轮都两人都拿了m+1
      return n%4!=0
  }
}