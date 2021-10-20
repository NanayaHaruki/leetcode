class Solution:GuessGame() {
    override fun guessNumber(n:Int):Int {
        var l = 1
        var r = n
        while(l<=r){
            val m = l+(r-l)/2
            when(guess(m)){
                0-> return m
                1-> l=m+1
                -1 -> r=m-1
            }
        }
        return -1
    }
}