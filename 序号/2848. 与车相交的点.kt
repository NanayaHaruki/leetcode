class Solution {
    fun numberOfPoints(nums: List<List<Int>>): Int {
        val n = nums.size
        val f=IntArray(102)
        for(i in nums.indices){
            f[nums[i][0]]++
            f[nums[i][1]+1]--
        }
        var sm = 0
        var ans = 0
        for (x in f){
            sm+=x
            if(sm>0) ans++
        }
        return ans
    }
}