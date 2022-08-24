class Solution {
  fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
    // 翻转就是冒泡排序，判断两数组元素是否一致即可
    val d = mutableMapOf<Int,Int>()
    for(i in arr.indices){
      val p = target[i];val q = arr[i]
      val pcnt = d.getOrDefault(p,0)
      d[p]=pcnt+1
      val qcnt = d.getOrDefault(q,0)
      d[q]=qcnt-1
      if(d[p]==0) d.remove(p)
      if(d[q]==0) d.remove(q)
    }
    return d.isEmpty()
  }
}