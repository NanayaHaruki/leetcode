import kotlin.random.Random
class RandomizedSet() {
  /** o1查询，需要用hash存取，
   * 随机需要用个角标来随机，用数组取值，最多执行200000次
   * 删除时，map自然删除，同时将数组中最后一位数字，挪入删除数字对应的角标处，这样保证索引是连续的，随机时不会随到已经被删除的元素
   * */
  private val arr = IntArray(20000)
  private val dict = mutableMapOf<Int, Int>()
  private var lastIndex = -1
  fun insert(`val`: Int): Boolean {
    if (dict.containsKey(`val`)) return false
    dict[`val`] = ++lastIndex
    arr[lastIndex] = `val`
    return true
  }
  
  fun remove(`val`: Int): Boolean {
    if (!dict.containsKey(`val`)) return false
    val idx = dict.remove(`val`)!!
    if (idx == lastIndex) {
      // 删的就是最后一个，清空最后一个
      lastIndex--
    } else {
      arr[idx] = arr[lastIndex]
      dict[idx]=idx
      lastIndex--
    }
    return true
  }
  
  fun getRandom(): Int {
    val randomIndex = Random.nextInt(lastIndex + 1)
    return arr[randomIndex]
  }
}
