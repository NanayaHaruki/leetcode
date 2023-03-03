class Solution {
  fun getFolderNames(names: Array<String>): Array<String> {
    // 如果没有，直接插入，如果后缀是（k），要判断前面的是否存在，存在要将当前k也加进去防止重复
    val d = mutableMapOf<String,Int>()
    for (i in names.indices){
      val name = names[i]
      if (name  !in d){
        d[name]=1
      }else{
        var k = d[name]!!
        while("${name}($k)" in d) k++
        d[name]=k // k 没有
        names[i]="$name($k)"
        d[names[i]]=1
      }
    }
    return names
  }
}