class Encrypter(keys: CharArray, values: Array<String>, dictionary: Array<String>) {
  /** 统计加密时，每个char 应该被替换成什么 */
  val ed = mutableMapOf<Char,String>().apply{
    val n = keys.size
    for(i in 0 until n){
      this[keys[i]]=values[i]
    }
  }

  /** 解密要统计原字符的次数，不如直接将原字符加密，统计次数 */
  val dd = mutableMapOf<String,Int>().apply { 
    for(d in dictionary){
      val encryptD = encrypt(d)
      val cnt = this.getOrDefault(encryptD, 0)
      this[encryptD]=cnt+1
    }
   }

  fun encrypt(word1: String): String {
    var ans = ""
    for(c in word1){
      if(ed.containsKey(c)){
        ans+=ed[c]
      }else{
        return ""
      }
    }
    return ans
  }

  fun decrypt(word2: String): Int {
    return dd.getOrDefault(word2, 0)
  }
}