import kotlin.random.Random
class Solution(n: Int, blacklist: IntArray) {
  val d = mutableMapOf<Int,Int>()
  var range =0
  init {
    // 尽量少的使用内置随机函数，将blacklist中的数字映射到最后去
    //  N为8，数字范围是0-7，  blacklist有3个 分别是 2 5 7，则将3个黑名单映射到最后的,567上去，随机时只在0-4之间随机，当随到2的时候，用5代替，如果5也有映射就继续映射
    val m = blacklist.size
    range = n-m
    blacklist.sort()
    var v = n-1
    for (i in blacklist.size-1 downTo 0){
      d[blacklist[i]]=v--
    }
  }
  fun pick(): Int {
    var a = Random.nextInt(range)
    var r :Int?
    do {
      r = d[a]
      if(r!=null) a = r
    }while(r!=null)
    return a
  }
}
