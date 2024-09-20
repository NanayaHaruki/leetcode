class Solution {

  fun countSpecialNumbers(n: Int): Int {
      val s = n.toString().toCharArray()
      // 需要记录i和mask的情况
      val mem = mutableMapOf<Long,Int>()
      fun dfs(i:Int,mask:Int,isLimit:Boolean,isNum:Boolean):Int{
          if (i==s.size){
              return if (isNum) 1 else 0
          }
          val k = i.toLong() shl 11 or mask.toLong()
           if (!isLimit && isNum && k in mem)
              return mem[k]!!
          var ans = 0
          if (!isNum) ans=dfs(i+1,mask,false,false)
          val hi = if (isLimit) s[i]-'0' else 9
          val lo = if (isNum) 0 else 1
          for (j in lo..hi){
              if(mask shr j and 1 == 0){
                  ans+=dfs(i+1,mask or (1 shl j),isLimit && j==hi,true)
              }
          }
          mem[k]=ans
          return ans
      }
      return dfs(0,0,true,false)
  }
}