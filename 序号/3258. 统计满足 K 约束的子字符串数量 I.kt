class Solution {
  fun countKConstraintSubstrings(s: String, k: Int): Int {
      // 右指针一直走，统计0和1出现了多少次
      // 不满足了，左指针往前走，左右之间所有子串都是满足的
      val cnts = IntArray(2)
      var l = 0
      var ans = 0
      s.forEachIndexed{j,c ->
          cnts[(c-'0').and(1)]+=1 // 更新0或1的数量
          while(cnts[0]>k && cnts[1]>k){ // 不满足条件，移动左指针
              cnts[(s[l]-'0').and(1)]-=1
              l++
          }
          // 前一个字符结束的子串，当然也是现在的子串
          // 以c结尾的子串，有j-l+1个
          ans+=j-l+1 
      }
      return ans
  }
}