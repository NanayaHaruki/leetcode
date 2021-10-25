class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        // peopel 体重 limit限制 返回运几次
        val list = people.sorted().toMutableList()
        var n = people.size
        var ans = 0
        var l = 0
        var r = n-1
        // 用最小的与接近limit最大的匹配
        while (n>0 && l<r){
            if (list[l]+list[r]<=limit){
                list[l]=-list[l]
                list[r]=-list[r]
                n-=2
                ans++
                l++
                r--
            }else {
                r--
                continue
            }
        }
        return ans+list.filter { it>0 }.size
    }
}