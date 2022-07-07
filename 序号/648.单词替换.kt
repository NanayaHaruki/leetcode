fun replaceWords(dictionary: List<String>, sentence: String): String {
  val d = dictionary.sorted()
  val strArr = sentence.split(" ").toMutableList()
  for (i in strArr.indices){
    for (root in d){
      if (strArr[i].startsWith(root)){
        strArr[i]=root
        break
      }
    }
  }
  return strArr.joinToString(" ")
}