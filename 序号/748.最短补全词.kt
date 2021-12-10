class Solution {
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        //找出words中包含license中所有字母的最短单词
        val charDict = mutableMapOf<Char,Int>()
        for ( c in licensePlate){
            if (c in 'a'..'z'){
                charDict[c]=charDict.getOrDefault(c,0)+1
            }else if (c in 'A'..'Z') {
                val c1 = c+('a'-'A')
                charDict[c1]=charDict.getOrDefault(c1,0)+1
            }
        }
        var ans = ""
        for (word in words){
            val wordCharDict = mutableMapOf<Char,Int>()
            for (c in word){
                wordCharDict[c]=wordCharDict.getOrDefault(c,0)+1
            }
            var wordOK = true
            for ((char,cnt) in charDict){
                if (wordCharDict.getOrDefault(char,0)>=cnt){
                    continue
                }else {
                    wordOK=false
                    break
                }
            }
            if (wordOK) {
                if (ans.isEmpty()) ans = word
                else if(ans.length>word.length) ans = word
            }
        }
        return ans
    }
}