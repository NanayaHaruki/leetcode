class Solution {
    fun numRabbits(answers: IntArray): Int {
        // 如果回答还有x只与自己相同，最少的情况是总共有x+1这种颜色
        // 让回答相同的刚好是相同颜色，可以尽可能减少兔子数量; 回答1有2只，让这2只同色最好。否则第1个回答1的是黑的，第2只回答1的是白的，那么没回答的兔子还要有1黑1白，总共4只了
        // 如果相同回答的超出了x+1，则必须加一种颜色
        var ans = 0
        val colors = IntArray(1000)
        for(x in answers){
            if(colors[x]==0){
                ans+=x+1
                colors[x]=x
            }else{
                colors[x]--
            }
        }
        return ans
    }
}