package main.kotlin

import kotlin.text.StringBuilder

class Solution {
  fun reverseOnlyLetters(s: String): String {
    var (l, r) = 0 to s.length - 1
    val arr = s.toCharArray()
    while (l < r) {
      if (!arr[l].isLetter()) {
        l++
      } else if (!arr[r].isLetter()) {
        r--
      } else {
        val tmp = arr[r]
        arr[r] = arr[l]
        arr[l] = tmp
        l++
        r--
      }
    }
    return String(arr)
  }
}


fun main() {
  val s = Solution()
  println(s.reverseOnlyLetters("a-bC-dEf-ghIj"))
  println(s.reverseOnlyLetters("Test1ng-Leet=code-Q!"))
}

fun printBit(num: Int, radix: Int) {
  val sb = StringBuilder()
  for (i in 31 downTo 0) {
    val bit = if ((num and (1 shl i)) == 0) '0' else '1'
    sb.append(bit)
    if (sb.length == 8) {
      print("${sb.toString().toInt(2).toString(radix)}_")
      sb.clear()
    }
  }
}

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}