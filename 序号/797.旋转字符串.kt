class Solution {
  fun rotateString(s: String, goal: String): Boolean {
    if (s.length!=goal.length) return false
    var startIndexS = 0
    var indexS = 0
    var indexG = 0
    while (startIndexS<s.length){
      if (goal[indexG] != s[startIndexS]) {
        startIndexS++
      }else{
        indexG++
        indexS=startIndexS+1
        if (indexS==s.length) indexS=0
        while (indexG<goal.length &&s[indexS] == goal[indexG] ) {
          indexS++
          if (indexS==s.length) indexS=0
          indexG++
        }
        if (indexG==goal.length) return true
        else {
          indexG=0
          startIndexS++
        }
      }
    }
    return false
  }
  
  
  fun rotateString(s: String, goal: String): Boolean {
    if (s.length!=goal.length) return false
    return (s+s).contains(goal)
  }
}