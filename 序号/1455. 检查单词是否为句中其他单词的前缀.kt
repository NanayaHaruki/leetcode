class Solution {
  fun isPrefixOfWord(sentence: String, searchWord: String): Int {
    var ans = -1
    val arr =sentence.split(" ")
    for(i in arr.indices){
      if(arr[i].startsWith(searchWord)){
        ans=i+1
        break
      }
    }
    return ans
  }
}