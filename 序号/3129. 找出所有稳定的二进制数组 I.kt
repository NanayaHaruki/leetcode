class Solution {
    private  val MOD:Int = 1000_000_007
    private lateinit var dict : Array<Array<IntArray>>
    private var limit = 0
    private fun dfs(i:Int, j:Int, k:Int):Int{
        val cacheKey = i or  (j shl 10) or (k shl 20)
        if (dict[i][j][k]!=-1)
            return dict[i][j][k]
        // 返回由i个0，j个1，最后一个是k的合法数量
        var ans = 0
        if (i==0){
            ans = if (k==1 && j<=limit){
                1
            }else{
                0
            }
        }else if(j==0){
            ans = if (k==0 && i<=limit){
                1
            }else{
                0
            }
        }else if(k==0){
            ans=dfs(i-1,j,0)+dfs(i-1,j,1)
            // ans包含了连续limit个0的情况，不能再添加0了，要排除掉后面limit位都是0的数量
            // i如果等于limit，说明i-1不可能有上面需要去除的情况
            if(i>limit){
                ans-=dfs(i-limit-1,j,1)
            }
        }else{
            ans=dfs(i,j-1,0)+dfs(i,j-1,1)
            if(j>limit){
                ans-=dfs(i,j-limit-1,0)
            }
        }
        ans%=MOD // d都是模过的，前面减法的时候可能会减成负的
        if (ans<0) ans+=MOD
        dict[i][j][k]=ans
        return ans
    }
    fun numberOfStableArrays(zero: Int, one: Int, _limit: Int): Int {
        limit=_limit
        dict = Array(zero+1){Array(one+1){IntArray(2){-1} } }
        return (dfs(zero,one,0)+dfs(zero,one,1))%MOD
    }
}