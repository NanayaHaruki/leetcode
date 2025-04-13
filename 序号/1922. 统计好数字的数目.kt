class Solution {
    fun quickPower(base:Long,exp:Long,mod:Int):Long{
        var b = base % mod
        var n = exp
        var ans = 1L
        while(n>0){
            if(n and 1L == 1L){
                ans = ans * b % mod
            }
            b = b*b%mod
            n /= 2
        }
        return ans
    }
    fun countGoodNumbers(n: Long): Int {
        // n为奇数，则有 n/2+1 个偶数位，n/2个奇数位;n为偶数，则有n/2个奇数偶数位
        // 偶数位取值有 0,2,4,6,8  5种
        // 奇数位取值有 2,3,5,7 4种
        val odd = n/2
        val even = (n+1)/2
        val mod = (1e9+7).toInt()
        return (quickPower(5,even,mod)*quickPower(4,odd,mod)%mod).toInt()
    }
}