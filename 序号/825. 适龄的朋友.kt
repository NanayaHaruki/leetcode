class Solution {
    fun findFriends(ages:IntArray,i:Int):Int{
        // 左边界开区间
        val minAge = ages[i]*0.5+7
        val maxAge = ages[i]
        if (minAge>maxAge) return 0
        var l = -1
        var r = ages.size
        while(l+1<r){
            val m = (l+r)/2
            if(ages[m]<=minAge){
                l=m
            }else{
                r=m
            }
        }
        val start = r
        l=-1;r=ages.size
        while(l+1<r){
            val m = (l+r)/2
            if(ages[m]>maxAge){
                r=m
            }else{
                l=m
            }
        }
        val end = l
        if (start>=end) return 0
        return end-start // [START,END]都是符合要求的，总共有end-start+1个人，去掉自己
    }
    fun numFriendRequests(ages: IntArray): Int {
        // 3个要求，确定左右边界，二分找有多少人
        ages.sort()
        var ans = 0
        for(i in ages.indices){
            ans+=findFriends(ages,i)
        }
        return ans
    }
}