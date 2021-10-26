class Solution {
    // 单调栈
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        // nums1 是 num2的子集，找nums1中每个元素在nums2中的位置，位置右边返回第一个比他大的数
        // 找右边第一个比nums1大的数，那就倒序遍历nums2,再用个栈存起来，
        // 比nums2[i]大的数弹栈，遍历到i的时候，栈顶就是离i最近的右边的大数，将答案存起来

        val ans = IntArray(nums1.size)
        val stack = Stack<Int>()
        val dict = mutableMapOf<Int,Int>()
        for(i in nums2.lastIndex downTo 0){
            val x = nums2[i]
            while(stack.isNotEmpty() && stack.peek()<=x){
                stack.pop()
            }
            dict[x]= if (stack.isEmpty()) -1 else stack.peek()
            stack.add(x)
        }
        for (i in nums1.indices){
            ans[i]=dict[nums1[i]]!!
        }
        return ans
    }
}