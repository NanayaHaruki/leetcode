class FindSumPairs(val nums1: IntArray,val nums2: IntArray) {
    private val m = mutableMapOf<Int,Int>().apply{
        for(x in nums2) merge(x,1,Int::plus)
    }
    fun add(index: Int, `val`: Int) {
        m.computeIfPresent(nums2[index]){k,v->
            v-1
        }
        m.merge(nums2[index]+`val`,1,Int::plus)
        nums2[index]+=`val`
    }

    fun count(tot: Int): Int {
        var ans = 0
        for (x in nums1){
            ans += m.getOrDefault(tot-x,0)
        }
        return ans
    }

}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * var obj = FindSumPairs(nums1, nums2)
 * obj.add(index,`val`)
 * var param_2 = obj.count(tot)
 */