class Solution() {
    fun findRepeatedDnaSequences(s: String): List<String> {
        // 找出现超过1次的子串，长度为10
        if (s.length<=10) return emptyList()
        val ans = mutableListOf<String>()
        val dict = mutableMapOf<String,Int>()
        val window = StringBuilder(s.subSequence(0,10))
        // 滑动窗口，从左往右挪，搞个字典，不存在丢进去，存在丢进ans
        dict[window.toString()] = 1
        for (i in 1..s.length-10){
            window.deleteAt(0)
            window.append(s[i+9])
            val cur = window.toString()
            dict[cur]=(dict[cur]?:0)+1
        }
        dict.forEach { (s, i) ->
            if (i>0){
                ans.add(s)
            }
        }
        return ans
    }
}