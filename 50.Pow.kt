fun myPow(x: Double, n: Int): Double {
    return when{
        n==0 -> 1.0
        n<0 -> {
            // +1 再*x 可以约去，这么做的目的是为了n为Int.min 时防止overflow
            1/myPow(x,-(n+1))/x
        }
        n%2==1-> myPow(x,n-1)*x
        else -> {
            val num = myPow(x,n/2)
            num*num
        }
    }
}