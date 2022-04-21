class Solution {
  val set = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
  fun toGoatLatin(sentence: String): String {
    val arr = sentence.split(' ').toMutableList()
    arr.forEachIndexed { index, word ->
      var newWord = word
      if (set.contains(word[0])) newWord += "ma"
      else newWord = word.substring(1) + word[0] + "ma"
      repeat(index + 1) {
        newWord += 'a'
      }
      
      arr[index] = newWord
    }
    return arr.joinToString(" ")
  }
}