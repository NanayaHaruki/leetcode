class Solution {
    fun myPow(x: Double, n: Int): Double {
        // x^n = x^(n/2)*x^(n/2)  不断二分即可
        // 需要注意 n可能为负值，而负值直接转正值会溢出
        if(n==0) return 1.0
        if(n==1) return x
        if(n<0){
            // return 1/myPow(x,-n)   这样会溢出
            // 负数的话，先+1，让他绝对值变小些，可以转成正数，但这样会少乘一次，所以再除掉x就行了
            return 1/myPow(x,-(n+1))/x
        }

        if(n%2==0){
            val ans = myPow(x,n/2)
            return ans*ans
        }else{
            return myPow(x,n-1)*x
        }

    }
}