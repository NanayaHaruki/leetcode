class Solution {
  fun maxDistance(s: String, k: Int): Int {
      // 东西向比较少的变更为多的，南北向少的变更为多的，加起来为k
      val cnts = IntArray(4) // 存 E W S N
      var ans = 0
      for(i in s.indices){
          when(s[i]){
              'E'->cnts[0]++
              'W'->cnts[1]++
              'S'->cnts[2]++
              else->cnts[3]++
          }
          val a = max(cnts[0],cnts[1])
          val b = min(cnts[0],cnts[1])
          val c = max(cnts[2],cnts[3])
          val d = min(cnts[2],cnts[3])
          ans = max(ans,a+c+if(b+d<=k) b+d else k-(b+d-k))
      }
      return ans
  }
}class Solution {
  fun maxDistance(s: String, k: Int): Int {
      // 东西向比较少的变更为多的，南北向少的变更为多的，加起来为k
      val cnts = IntArray(4) // 存 E W S N
      var ans = 0
      for(i in s.indices){
          when(s[i]){
              'E'->cnts[0]++
              'W'->cnts[1]++
              'S'->cnts[2]++
              else->cnts[3]++
          }
          val a = max(cnts[0],cnts[1])
          val b = min(cnts[0],cnts[1])
          val c = max(cnts[2],cnts[3])
          val d = min(cnts[2],cnts[3])
          ans = max(ans,a+c+if(b+d<=k) b+d else k-(b+d-k))
      }
      return ans
  }
}class Solution {
  fun maxDistance(s: String, k: Int): Int {
      // 东西向比较少的变更为多的，南北向少的变更为多的，加起来为k
      val cnts = IntArray(4) // 存 E W S N
      var ans = 0
      for(i in s.indices){
          when(s[i]){
              'E'->cnts[0]++
              'W'->cnts[1]++
              'S'->cnts[2]++
              else->cnts[3]++
          }
          val a = max(cnts[0],cnts[1])
          val b = min(cnts[0],cnts[1])
          val c = max(cnts[2],cnts[3])
          val d = min(cnts[2],cnts[3])
          ans = max(ans,a+c+if(b+d<=k) b+d else k-(b+d-k))
      }
      return ans
  }
}class Solution {
  fun maxDistance(s: String, k: Int): Int {
      // 东西向比较少的变更为多的，南北向少的变更为多的，加起来为k
      val cnts = IntArray(4) // 存 E W S N
      var ans = 0
      for(i in s.indices){
          when(s[i]){
              'E'->cnts[0]++
              'W'->cnts[1]++
              'S'->cnts[2]++
              else->cnts[3]++
          }
          val a = max(cnts[0],cnts[1])
          val b = min(cnts[0],cnts[1])
          val c = max(cnts[2],cnts[3])
          val d = min(cnts[2],cnts[3])
          ans = max(ans,a+c+if(b+d<=k) b+d else k-(b+d-k))
      }
      return ans
  }
}class Solution {
  fun maxDistance(s: String, k: Int): Int {
      // 东西向比较少的变更为多的，南北向少的变更为多的，加起来为k
      val cnts = IntArray(4) // 存 E W S N
      var ans = 0
      for(i in s.indices){
          when(s[i]){
              'E'->cnts[0]++
              'W'->cnts[1]++
              'S'->cnts[2]++
              else->cnts[3]++
          }
          val a = max(cnts[0],cnts[1])
          val b = min(cnts[0],cnts[1])
          val c = max(cnts[2],cnts[3])
          val d = min(cnts[2],cnts[3])
          ans = max(ans,a+c+if(b+d<=k) b+d else k-(b+d-k))
      }
      return ans
  }
}class Solution {
  fun maxDistance(s: String, k: Int): Int {
      // 东西向比较少的变更为多的，南北向少的变更为多的，加起来为k
      val cnts = IntArray(4) // 存 E W S N
      var ans = 0
      for(i in s.indices){
          when(s[i]){
              'E'->cnts[0]++
              'W'->cnts[1]++
              'S'->cnts[2]++
              else->cnts[3]++
          }
          val a = max(cnts[0],cnts[1])
          val b = min(cnts[0],cnts[1])
          val c = max(cnts[2],cnts[3])
          val d = min(cnts[2],cnts[3])
          ans = max(ans,a+c+if(b+d<=k) b+d else k-(b+d-k))
      }
      return ans
  }
}