class Solution() {
    val memory = mutableMapOf<Int,Int>().apply { put(0,0)
        put(1,1)}
    val mod = 1000000007
    fun fib(n: Int): Int {
        if(n<2) return n
        var ans = memory[n]
        return if (ans == null){
            ans = (fib(n-1)+fib(n-2)) % mod
            memory[n]=ans
            println("$n $ans")
            ans
        }else {
            ans
        }
    }
}