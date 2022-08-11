import kotlin.math.abs
class Solution {
  fun reformat(s: String): String {
    // 格式化字符串，数字和字母相继出现
    val a = ArrayDeque<Char>()
    val b = ArrayDeque<Char>()
    for (c in s) if(c in '0'..'9') a.add(c) else b.add(c)
    if (abs(a.size-b.size) >1) return ""
    val ans = StringBuilder()
    if (a.size>b.size) {
      ans.append(a.removeFirst())
      while(b.isNotEmpty()) ans.append(b.removeFirst()).append(a.removeFirst())
    }else if(a.size<b.size){
      ans.append(b.removeFirst())
      while(b.isNotEmpty()) ans.append(a.removeFirst()).append(b.removeFirst())
    }else{
      while(b.isNotEmpty()) ans.append(a.removeFirst()).append(b.removeFirst())
    }
    return ans.toString()
  }
}