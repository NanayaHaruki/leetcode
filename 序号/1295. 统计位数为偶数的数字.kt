class Solution {
    fun findNumbers(nums: IntArray): Int = nums.sumOf{
            var x = it
            while(x>=100) x/=100
            if(x<10) 0.toInt() else 1
        }
}