fun intersect(quadTree1: Node?, quadTree2: Node?): Node? {
  // 四叉树 当四个节点值相同，则父节点为叶子节点，将值设为子节点的相同值，子节点为null
  // 两棵树进行或运算，生成新树
  if (quadTree1 == null || quadTree2 == null) return null
  return if (quadTree1.isLeaf && quadTree2.isLeaf) {
    // 两个都是叶子，直接或
    Node(quadTree1.`val` || quadTree2.`val`, true)
  } else if (quadTree1.isLeaf && !quadTree2.isLeaf) {
    // 1是叶子，1为true 直接返回1，因为1或什么都是1； 1为false，直接返回2即可，0或什么玩意都还是那个玩意
    if (quadTree1.`val`) Node(true, true) else quadTree2
  } else if (!quadTree1.isLeaf && quadTree2.isLeaf) {
    if (quadTree2.`val`) Node(true, true) else quadTree1
  } else {
    // 都不是叶子，就递归到上面3种情况去处理
    val tl = intersect(quadTree1.topLeft!!, quadTree2.topLeft!!) ?: return null
    val tr = intersect(quadTree1.topRight!!, quadTree2.topRight!!) ?: return null
    val bl = intersect(quadTree1.bottomLeft!!, quadTree2.bottomLeft!!) ?: return null
    val br = intersect(quadTree1.bottomRight!!, quadTree2.bottomRight!!) ?: return null
    if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf && tl.`val` == tr.`val` && tl.`val` == bl.`val` && tl.`val` == br.`val`) {
      Node(tl.`val`, true)
    } else {
      Node(false, false).apply {
        topLeft = tl;topRight = tr;bottomLeft = bl;bottomRight = br
      }
    }
  }
}