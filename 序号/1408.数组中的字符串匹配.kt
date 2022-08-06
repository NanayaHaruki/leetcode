class Solution {
  fun stringMatching(words: Array<String>): List<String> {
    val ans = mutableListOf<String>();val n = words.size
    for (i in 0 until n){
      for (j in 0 until n){
        // 遍历words，再遍历是否为其他word的字串，所以子串在外循环
        if (i!=j && words[j].contains(words[i])) {
          ans.add(words[i])
          break
        }
      }
    }
    return ans
  }
}