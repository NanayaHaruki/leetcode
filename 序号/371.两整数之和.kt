
class Solution() {
    fun getSum(a: Int, b: Int): Int {
        // 2+3=lne^(2+3)=ln(e^2*e^3)
        return ln(exp(a.toDouble())* exp(b.toDouble())).toInt()
    }
}