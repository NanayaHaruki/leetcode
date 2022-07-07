package main.kotlin

import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList

class Solution {
  fun replaceWords(dictionary: List<String>, sentence: String): String {
    // dictionary.sortedWith{a,b-> a.length-b.length}
    dictionary.sortedWith(object:Comparator<String>{
      override fun compare(o1: String, o2: String): Int {
        return o1.length-o2.length
      }
    })
    val strArr = sentence.split(" ").toMutableList()
    for (i in strArr.indices){
      for (root in dictionary){
        if (strArr[i].startsWith(root)){
          strArr[i]=root
          break
        }
      }
    }
    return strArr.joinToString(" ")
  }
}


fun main() {
  val s = Solution()
  val a = s.replaceWords(
    listOf("a","b","c"),
    "aadsfasf absbs bbab cadsfafs"
  )
  println(a)
  
}

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}