class TrieNode {
  val next = Array<TrieNode?>(28) { null }
  val idx = mutableListOf<Int>() // 拥有这个前缀的字符串的索引位置
}

class WordFilter(words: Array<String>) {
  val root = TrieNode()
  
  init {
    root.next[26]= TrieNode()
    root.next[27]= TrieNode()
    // word仅由小写字母构成，查询前后缀是否存在
    for (i in words.indices) {
      var preNode = root.next[26]!!
      var sufNode = root.next[27]!!
      val word = words[i]
      for (j in word.indices) {
        val preChar = word[j]
        val sufChar = word[word.length - 1 - j]
        
        if (preNode.next[preChar - 'a'] == null) preNode.next[preChar - 'a'] = TrieNode()
        preNode = preNode.next[preChar - 'a']!!
        preNode.idx.add(i)
        
        if (sufNode.next[sufChar - 'a'] == null) sufNode.next[sufChar - 'a'] = TrieNode()
        sufNode = sufNode.next[sufChar - 'a']!!
        sufNode.idx.add(i)
      }
    }
    
  }
  
  fun f(pref: String, suff: String): Int {
    var n = root.next[26]!!
    for (c in pref) {
      val nodeArr = n.next[c - 'a'] ?: return -1
      n = nodeArr
    }
    var m = root.next[27]!!
    for (i in suff.indices) {
      val c = suff[suff.length-1-i]
      val nodeArr = m.next[c - 'a'] ?: return -1
      m = nodeArr
    }
    // words是一个个添加的，idx必然升序，只要找到idx1和idx2后序的第一个相同值即可
    var i=n.idx.size-1;var j = m.idx.size-1;
    val li=n.idx;val lj=m.idx
    while(i>=0&&j>=0){
      if (li[i]==lj[j]) return li[i]
      if(li[i]>lj[j]) i-- // 要找一样的，现在i大了，就让i小点
      else j--
    }
    return -1
  }
}