class Solution() {
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        // 测量长度
        var p = head
        var size = 0
        while (p != null) {
            size++
            p = p.next
        }
        // 计算每个答案的node长度为 cnt+mod
        // 分成k 组，每组cnt个元素
        val cnt = size / k
        // k组中前mod个 多分配一个
        var mod = size % k

        val ans = Array<ListNode?>(k) { null }
        p = head
        for (i in 0 until k) {
            val curSize = if (mod>0) cnt+1 else cnt
            if (mod>0) mod--
            // 生成第i个node
            if (p == null) break
            val node = p
            for (j in 1 until curSize) {
                p=p?.next
            }
            val last = p
            p = p?.next
            last?.next=null
            ans[i]=node
        }
        return ans
    }
}