class Solution {
    val mem = mutableMapOf<Int,Int>()
    fun dfs(x:Int):Int{
        // 如果 x是偶数，x变成1的步数，就是dfs(x/2)+1
        // 如果 x是奇数，第1步变成3x+1是偶数,步数是dfs(3x+1)，第2步变成 dfs((3x+1)/2)+1
        if (x==1) return 0
        if (mem.containsKey(x)) return mem[x]!!
        val ans =  if (x%2==0) dfs(x/2)+1
        else dfs(3*x+1)+1
        mem[x]=ans
        return ans
    }
    fun getKth(lo: Int, hi: Int, k: Int): Int {
        // 大顶堆，长度为k, 里面元素IntArray[0]是步数，1是原本的值
        val ans = (lo..hi).sortedWith{a,b->
            val stepA = dfs(a)
            val stepB = dfs(b)
            if (stepA==stepB){
                a-b
            }else{
                stepA-stepB
            }
        }
        return ans[k-1]
    }
}