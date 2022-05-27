// 方法一  N+N1*logN2   372ms
fun findClosest(words: Array<String>, word1: String, word2: String): Int {
  // 找2个单词中间隔了几个单词 返回最短距离
  val t1 = sortedSetOf<Int>();val t2 = sortedSetOf<Int>()
  words.forEachIndexed { index, s ->
    when(s){
      word1-> t1.add(index)
      word2->t2.add(index)
    }
  }
  var ans = Int.MAX_VALUE
  for (i in t1){
    val l = t2.lower(i);val r = t2.higher(i)
    if (l!=null) ans = minOf(ans,i-l)
    if (r!=null) ans = minOf(ans,l-i)
  }
  return ans
}


// 方法二 N   304ms
fun findClosest(words: Array<String>, word1: String, word2: String): Int {
  // 找2个单词中间隔了几个单词 返回最短距离
  // 用2个指针记录单词出现的最新索引，不断比对，可以在N时间内解
  var (i,j,ans) = intArrayOf(-1,-1,Int.MAX_VALUE)
  words.forEachIndexed { index, s ->
    when(s){
      word1->{
        if (j!=-1) ans = minOf(ans,index-j)
        i=index
      }
      word2->{
        if (i!=-1) ans = minOf(ans,index-i)
        j=index
      }
    }
  }
  return ans
}