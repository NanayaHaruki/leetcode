class Solution {
    fun sortColors(nums: IntArray): Unit {
        // 发现红色丢左边去，发现蓝色丢右边去
        var total0 = 0
        var total01= 0
        nums.forEachIndexed{i,x->
            nums[i]=2
            if(x<=1) nums[total01++]=1
            if(x==0) nums[total0++]=0
        }
    }
}

class Solution {
    fun sortColors(nums: IntArray): Unit {
        // 发现红色丢左边去，发现蓝色丢右边去
        var r = 0
        var w = 0
        var b = 0
        val n = nums.size
        for(x in nums){
            when(x){
                0->r++
                1->w++
                2->b++
            }
        }
        for(i in nums.indices){
            when{
                i<r->nums[i]=0
                i>=n-b->nums[i]=2
                else->nums[i]=1
            }
        }
    }
}