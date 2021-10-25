class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val list = mutableListOf<Int>()
        for(i in nums1) {
            if(nums2.contains(i) && !list.contains(i))
                list.add(i)
        }
        return list.toIntArray()
    }
}
