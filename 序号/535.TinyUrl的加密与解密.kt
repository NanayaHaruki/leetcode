class Codec() {
  
  // 存储字符的索引位置
  fun encode(longUrl: String): String {
    val arr = CharArray(longUrl.length)
    for (i in longUrl.indices){
      arr[i]=longUrl[i]+7
    }
    return String(arr)
  }
  
  // Decodes a shortened URL to its original URL.
  fun decode(shortUrl: String): String {
    val arr = CharArray(shortUrl.length)
    for (i in shortUrl.indices){
      arr[i]=shortUrl[i]-7
    }
    return String(arr)
  }
}