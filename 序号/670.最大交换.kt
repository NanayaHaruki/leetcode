/*执行用时：116 ms, 在所有 Kotlin 提交中击败了100.00% 的用户
内存消耗：32.4 MB, 在所有 Kotlin 提交中击败了30.00% 的用户
 */

fun maximumSwap(num: Int): Int {
  // 交换一个数字，使其最大
  // 倒序遍历，继续最大的字符，与前面较小的数字不断交换，贪心取最小
  val arr = num.toString().toCharArray()
  var ans = num // 取最大
  var max=-1;var maxIdx =0
  for (i in arr.size-1 downTo 0){
    val curNum = arr[i]-'0'
    if (curNum>max){
      max=curNum
      maxIdx=i
    }else if(curNum<max){
      var tmp = arr[i]
      arr[i]=arr[maxIdx]
      arr[maxIdx]=tmp
      val swap = String(arr).toInt()
      if (swap>ans){
        ans=swap
      }
      arr[maxIdx]=arr[i]
      arr[i]=tmp
    }
  }
  return ans
}


/** 将每一位的数字取出来倒序排序。
 *  重新遍历原数字，找到第一个和排序好的顺序不一致的，即为可以交换的数字。
 *  检查倒序排序的数字原先所在的索引，与不一致的索引交换即可。
 *  执行用时：172 ms, 在所有 Kotlin 提交中击败了10.00% 的用户
    内存消耗：33.2 MB, 在所有 Kotlin 提交中击败了10.00% 的用户
 * */
fun maximumSwap(num: Int): Int {
  // 交换一个数字，使其最大
  // 将所有数字拿出来排序，再从最高位遍历，不是不满足倒序排序，就更换。如果有2个相同大的数在后面，从小的换。 199 - 991（919是错的）
  val l = mutableListOf<Int>()
  val d = mutableMapOf<Int, TreeSet<Int>>() // key-num  value-index
  val s = num.toString().toCharArray()
  for (i in s.indices) {
    val j = s[i]-'0'
    val set = d.getOrDefault(j, TreeSet())
    set.add(i)
    d[j] = set
    l.add(j)
  }
  
  l.sortDescending()
  for ( i in s.indices){
    val j = s[i]-'0'
    if (j!=l[i]){
      val idx = d[l[i]]!!.last()
      val tmp = s[i]
      s[i]=s[idx]
      s[idx]=tmp
      break // 只能换一次
    }
  }
  return String(s).toInt()
}