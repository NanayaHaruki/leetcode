class Solution {
  fun minOperations(nums: IntArray): Int {
      val n = nums.size
      val k = 3
      val q = ArrayDeque<Int>()
      var ans = 0
      nums.forEachIndexed{i,x->
          while(q.isNotEmpty() && q.first()+k-1<i){
              q.removeFirst()
          }
          if(x.plus(q.size).and(1)==0){
              if(i+k>n) return -1
              q.add(i)
              ans++
          }
      }
      return ans
  }
}