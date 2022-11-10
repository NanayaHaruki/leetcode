package main.kotlin

import java.util.*
import java.io.File
import kotlin.math.log
import kotlin.math.pow

const val mod = (1e9 + 7).toInt()



@Strictfp
fun main() {
  println(File.separator)
  println(File.separatorChar)
}

fun createTree(arr: Array<Int?>): List<TreeNode?> {
  val nodeList = arr.map { if (it == null) null else TreeNode(it) }
  // i 为数组索引 ，layer为层数 ，j为当前层索引，左子树在下一层的索引为2*j，右子树在下一层索引为2*j+1
  // 每层节点数n = 2^layer,当前层索引j 为 i-（上层所有节点数）
  var preLayerSum = 0
  val size = arr.size
  // 根据等比数列求和公式求出最大层数 a1（1-q^n)/1-q = size
  val maxLayer = (log((size * 2 + 1).toDouble(), 2.0)).toInt() - 1

  for (layer in 0 until maxLayer) { // 最后一层没必要设置子树了
    val curLayerSize = (2.0.pow(layer)).toInt()
    for (j in 0 until curLayerSize) {
      val node = nodeList[j + preLayerSum]
      node?.left = nodeList[2 * j + preLayerSum + curLayerSize]
      node?.right = nodeList[2 * j + 1 + preLayerSum + curLayerSize]
    }
    preLayerSum += curLayerSize
  }
  return nodeList
}

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}

class Node(var `val`: Boolean, var isLeaf: Boolean) {
  var topLeft: Node? = null
  var topRight: Node? = null
  var bottomLeft: Node? = null
  var bottomRight: Node? = null
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null

  override fun toString(): String {
    return "val=$`val` left = ${left?.`val`} right = ${right?.`val`}"
  }
}
