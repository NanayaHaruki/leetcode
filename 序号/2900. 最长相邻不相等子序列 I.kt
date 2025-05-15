class Solution {
  fun getLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
      // 找最长的序列，使相邻元素不同。但groups是二进制，所以必定是0101010 或1010101
      // 找到最长的后替换成Words中的字符
      val n = groups.size
      val l0 = mutableListOf<Int>() // 以0开头，0出现在偶数位
      val l1 = mutableListOf<Int>()
      groups.forEachIndexed{ i,x->
          if(x==0){
              if(l0.size % 2 == 0) l0.add(i)
              if(l1.size % 2 == 1) l1.add(i)
          }else{
              if(l0.size % 2 == 1) l0.add(i)
              if(l1.size % 2 == 0) l1.add(i)
          }
      }
      return maxOf(l0,l1){a,b->a.size-b.size}.map { words[it] }
  }
}