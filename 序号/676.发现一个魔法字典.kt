class MagicDictionary() {
  val d = mutableMapOf<Int,MutableSet<String>>()
  fun buildDict(dictionary: Array<String>) {
    // 查询时，变更一个字母是否存在
    for (str in dictionary){
      val set = d.getOrDefault(str.length, mutableSetOf())
      set.add(str)
      d[str.length]=set
    }
    
  }
  
  fun search(searchWord: String): Boolean {
    val set = d[searchWord.length]
    if (set==null) return false
    val ds = mutableMapOf<Char,Int>() // 存储searchWord的字符出现了几次
    for (existStr in set){
      // 判断existStr 与searchWord是否之差一个字母
      var diffCount = 0
      for (i in searchWord.indices){
        if (searchWord[i]!=existStr[i]) diffCount++
      }
      if (diffCount==1) return true
    }
    return false
  }
}