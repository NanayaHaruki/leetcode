class Solution {
  fun robotWithString(s: String): String {
      val q = ArrayDeque<Char>()
      // 统计后缀最小值
      val n = s.length
      val sufMin = CharArray(n+1){'z'}
      for(i in n-1 downTo 0){
          sufMin[i] = if(sufMin[i+1]<s[i]) sufMin[i+1] else s[i]
      }
      val ans = StringBuilder()
      s.forEachIndexed{ i,c->
          q.add(c)
          while(q.isNotEmpty() && q.last()<=sufMin[i+1]){
              ans.append(q.removeLast())
          }
      }
      return ans.toString()
  }
}

class Solution {
  fun findNextIdx(s: String,idx:Array<MutableList<Int>>,p:Int):Int{
      val target = if(p==-1) 0 else s[p]-'a'
      var ans = -1
      for(x in target until 26){
          val lst = idx[x]
          if(lst.isEmpty() || lst.last()<=p) continue
          var l = -1
          var r = lst.size
          while(l+1<r){
              val mid = (l+r)/2
              if(lst[mid]<=p) l=mid
              else r = mid
          }
          ans = lst[r]
          break
      }
      return ans
  }
  fun robotWithString(s: String): String {
      val n = s.length
      val idx = Array(26){mutableListOf<Int>()}
      s.forEachIndexed{i,c->idx[c-'a'].add(i)}
      // 找a ，a前面的倒序，找到了继续往后找a
      val ans = StringBuilder()
      val t = StringBuilder()
      var p = -1

      while(ans.length<n){
          val nxtIdx = findNextIdx(s,idx,p)
          if(nxtIdx==-1) ans.append(t.reverse())
          else{
              while(t.isNotEmpty() && t.last()<=s[nxtIdx]){
                  ans.append(t.last())
                  t.setLength(t.length-1)
              }
              ans.append(s[nxtIdx])
              t.append(s.substring(p+1,nxtIdx))
              p = nxtIdx
          }
      }
      return ans.toString()
  }
}