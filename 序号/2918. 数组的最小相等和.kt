class Solution {
    fun minSum(nums1: IntArray, nums2: IntArray): Long {
        var (s1,z1,s2,z2) = LongArray(4)
        for(x in nums1){
            if(x==0)z1++
            else s1+=x
        }
        for (x in nums2){
            if(x==0) z2++
            else s2+=x
        }
        // 只要有0，怎么都能相等，要考虑的是最小和能是多少; 没有0无法变更，可能无法满足条件
        if((z1==0L && s2+z2>s1) || (z2==0L && s1+z1>s2))return -1
        return max(s1+z1,s2+z2)
    }
}