class Solution {
  fun countKConstraintSubstrings(s: String, k: Int, queries: Array<IntArray>): LongArray {
      // 要查询，先固定右边界，找出满足条件的左边界在哪
      // 左边界小于查询左边界，则查询范围所有子串都满足条件，有 (1+r-l+1)*(r-l+1)/2
      // 左边界大于查询左边界，则根据范围计算满足的子串
      val cnts = IntArray(2)
      val n = s.length
      val ps = LongArray(n+1)
      var l = 0
      val right = IntArray(n){n}
      s.forEachIndexed{r,c->
          cnts[(c-'0').and(1)]++
          while(cnts[0]>k && cnts[1]>k){
              cnts[(s[l]-'0').and(1)]--
              right[l]=r
              l++
          }
          ps[r+1]=ps[r]+r-l+1
      }
      val ans = LongArray(queries.size)
      queries.forEachIndexed{i,(ql,qr)->
          val r = min(right[ql],qr+1)
          ans[i]= ps[qr+1]-ps[r]+(r-ql+1).toLong()*(r-ql)/2

      }
      return ans
  }
}