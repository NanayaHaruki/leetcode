class Solution {
    fun checkRecord(s: String): Boolean {
        // A L P  缺席 迟到  到席
        // A>=2 false  ||  出现LLL 连续的3次 false
        var ACnt = 0
        var LCnt = 0
        for (c in s){
            when(c){
                'A'-> {
                    ACnt++
                    LCnt=0
                    if (ACnt>=2) return false
                }
                'L'->{
                    LCnt++
                    if (LCnt==3) return false
                }
                else ->{
                    LCnt=0
                }
            }
        }
        return true
    }
}