class MedianFinder() {
    /** 小的是大顶堆，堆顶是最大数 */
    val leftQueue = PriorityQueue(Collections.reverseOrder<Int>())

    /** 大数的是小顶堆，堆顶是最小数 */
    val rightQueue = PriorityQueue<Int>()

    /** 偶数 维持2个队列数量相同，中位数就是2个堆堆顶的平均值
     *  奇数 往左队列先增，中位数就是左队列的堆顶 */
    fun addNum(num: Int) {
        if (leftQueue.size>rightQueue.size){
            // 左树多，右树加
            // 判断这个数是否大与左树顶
            if (leftQueue.peek() <= num) {
                rightQueue.add(num)
            }else {
                // num 比左树顶小，左树顶移动到右树顶，num替换掉左树顶
                val leftTop = leftQueue.poll()
                leftQueue.add(num)
                rightQueue.add(leftTop)
            }
        }else {
            // 等长，左树空，右树也空，往左树加完事儿
            if (leftQueue.isEmpty()){
                leftQueue.add(num)
                return
            }else {
                // 两树长度相同，优先往左树添加
                val rightTop = rightQueue.peek()
                if (num <= rightTop) {
                    leftQueue.add(num)
                }else {
                    // 右树顶比较小，树顶替换成num，将右树顶添加到左树
                    rightQueue.poll()
                    rightQueue.add(num)
                    leftQueue.add(rightTop)
                }
            }

        }
    }

    fun findMedian(): Double {
        return if (leftQueue.size == rightQueue.size) {
            (leftQueue.peek()+rightQueue.peek())/2.0
        }else {
            leftQueue.peek().toDouble()
        }
    }
}