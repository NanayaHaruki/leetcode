class Solution {
    private val mIps = mutableMapOf<Int,Boolean>()
    private val mDfs = mutableMapOf<Int,Int>()
    lateinit var s :String
    private fun ips(start:Int,end:Int):Boolean{
        var (l,r) = start to end
        if(l>r) return false
        if(l==r) return true
        val k = l.shl(16).or(r)
        if(mIps.contains(k)) return mIps[k]!!
        var ans = true
        while(l<r){
            if(s[l++]!=s[r--]) {
                ans = false
                break
            }
        }
        mIps[k]=ans
        return ans
    }

    private fun dfs(r:Int):Int{
        if(mDfs.contains(r)) return mDfs[r]!!
        if(ips(0,r)) return 0 // 不用切割了
        var ans = Int.MAX_VALUE
        for(l in 1 .. r){ // l数切割的位置，左边是[0,l-1],右边是[l,r]
            if(ips(l,r)){ // 右边已经是回文了，左边的最小次数+1就是答案
                ans = min(ans,dfs(l-1)+1)  
            }
        }
        mDfs[r]=ans
        return ans
    }
    fun minCut(_s: String): Int {
        s=_s
        return dfs(s.length-1)
    }
}