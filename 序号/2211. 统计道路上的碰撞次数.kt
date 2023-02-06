class Solution {
  fun countCollisions(directions: String): Int {
    var l = 0  
    val n = directions.length
    var r = n-1
    while(l<n && directions[l]=='L') l++
    while(r>=0 && directions[r]=='R') r--
    var stopCnt = 0
    for(i in l..r){
      if (directions[i]=='S') stopCnt++
    }
    return r-l+1-stopCnt
  }
}