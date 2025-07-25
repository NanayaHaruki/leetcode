class Solution {
    fun maxSum(nums: IntArray): Int {
        // 最大化 将负的删掉，互不相同，将重复的干掉
        val st = mutableSetOf<Int>()
        var ans = 0
        var mx = -0x3f3f3f3f
        for(x in nums){
            mx = max(mx,x)
            if(x<=0) continue
            if(!st.contains(x)){
                st.add(x)
                ans+=x
            }
        }
        return if(st.isNotEmpty()) ans else mx
    }
}