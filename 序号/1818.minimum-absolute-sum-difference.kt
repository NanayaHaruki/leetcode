class Solution {
    fun minAbsoluteSumDiff(nums1: IntArray, nums2: IntArray): Int {
        val mod = 1_000_000_007
        // 遍历每个数计算差值和  找最接近的数替换看看能将该差值减少多少，不断更新这个单次差值的最大值，遍历完之后sum-max
        val sortNums1 = nums1.sorted()
        var sum = 0
        var max = 0
        for (i in nums1.indices){
            val a = nums1[i]
            val b = nums2[i]
            val diff = abs(a-b)
            sum = (sum+diff) % mod //每次都模一下，防止溢出
            var l = 0
            var r = sortNums1.lastIndex
            while(l<=r){
                val mid = (l+r)/2
                if (sortNums1[mid] > b) {
                    r=mid-1
                }else if (sortNums1[mid] < b) {
                    l=mid+1
                }else if(sortNums1[mid]==b){
                    l=mid+1
                }
            }
            // 比较l和l-1 谁与b 更接近  l的区间为[0,nums1.size] 可能会出界
            val diffChanged = if (l==0) abs(sortNums1.first()-b)
            else if(l == sortNums1.size) abs(sortNums1.last()-b)
            else {
                val c= abs(sortNums1[l]-b)
                val d = abs(sortNums1[l-1]-b)
                min(c,d)
            }
            max = max(max,diff-diffChanged)
        }
        return (mod+sum-max) % mod //sum每次都模了，防止差值出现负数，先加一个mod
    }
}