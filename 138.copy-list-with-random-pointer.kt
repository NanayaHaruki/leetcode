class Solution {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null
        // 遍历一遍，存进map key为node value为index，遍历同时构造新的链表
        // 遍历第2遍，从random中找到node，通过map找到index，在新的链表中操作指针指向新链表中对应的index的新的node
        val map = mutableMapOf<Node, Int>()
        val list = mutableListOf<Node>()

        val preHead = Node(0)
        var newP: Node? = null

        var p: Node? = node
        var index = 0
        while (p != null) {
            map[p] = index
            if (index == 0) {
                newP = Node(p.`val`)
                preHead.next = newP
                list.add(newP)
            } else {
                newP!!.next = Node(p.`val`)
                newP = newP.next
                list.add(newP!!)
            }
            p = p.next
            index++
        }

        p = node
        index = 0
        while (p != null) {
            val random = p.random
            if (random != null) {
                list[index].random = list[map[random]!!]
            }
            index++
            p = p.next
        }
        return preHead.next
    }
}