class Solution {
    fun generateKey(num1: Int, num2: Int, num3: Int): Int {
        var a=num1;var b=num2;var c=num3
        var x = 0
        for(i in 0 until 4){
            x+=intArrayOf( a%10,b%10,c%10).min()*10.0.pow(i).toInt()
            a/=10
            b/=10
            c/=10
        }
        return x
    }
}