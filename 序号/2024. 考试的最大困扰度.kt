class Solution {

    fun check(ps:IntArray,len: Int,k:Int): Boolean {
        for(i in len until ps.size){
            // 全都改成T 或 全都改成F
            if(ps[i]-ps[i-len]+k>=len || ps[i]-ps[i-len]<=k) return true
        }
        return false
    }

    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
        // 二分可能的最大连续长度
        // 根据前缀和+滑动窗口，查找当前二分的答案能否满足要求
        val n = answerKey.length
        val ps = IntArray(n + 1)
        for (i in answerKey.indices) {
            ps[i + 1] = ps[i] + if (answerKey[i] == 'T') 1 else 0
        }
        var l = 0
        var r = answerKey.length + 1
        while (l + 1 < r) {
            val m = (l + r) / 2
            if(check(ps,m,k)){
                l=m
            }else{
                r=m
            }
        }
        return l
    }
}