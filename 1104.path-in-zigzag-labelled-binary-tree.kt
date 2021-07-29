class Solution {
    fun pathInZigZagTree(label: Int): List<Int> {
        // 之字形排列的满二叉树，找到目标值
        // 第n层的值为[2^(n-1),2^n-1],一直建立表，直到找到目标值，建表时注意奇偶反转。
        // 建立好层数后，数一下目标值在第m组（2个数一组），那么在上一层的索引就是m/2,以此往回搜

        // 建树
        val list = mutableListOf<IntArray>()
        list.add(IntArray(0))
        var max = 1
        var n = 1
        while (true) {
            // 奇数从左到右排列
            val arr = IntArray(2.0.pow(n-1).toInt()) // 每一层有2^(n-1)个数
            var subMax = max
            if (n%2==1){
                for (i in arr.lastIndex downTo 0){
                    arr[i]=subMax--
                }
            }else {
                for (i in arr.indices) {
                    arr[i]=subMax--
                }
            }
            list.add(arr)
            if (max>=label) break
            n++
            max = 2.0.pow(n).toInt()-1
        }
        val ans = mutableListOf<Int>()
        var point = label
        while (point != 1) {
            ans.add(point)
            val index = list[n--].indexOf(point)/2
            point = list[n][index]

        }
        ans.add(1)
        return ans.reversed()
    }
}