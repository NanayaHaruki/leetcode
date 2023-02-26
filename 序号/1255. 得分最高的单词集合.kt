class Solution {
    val charCnts = IntArray(26)
    var mx = 0
    lateinit var ws:Array<String>
    lateinit var score:IntArray
    fun maxScoreWords(words: Array<String>, letters: CharArray, _score: IntArray): Int {
        score=_score
        ws=words
        for ( c in letters) charCnts[c-'a']++
        dfs(0,0)
        return mx
    }

    fun dfs(idx:Int,curScore:Int){
        if (idx==ws.size){
            mx= maxOf(mx,curScore)
            return
        }
        dfs(idx+1,curScore)
        var canSelect = true
        var s = 0
        for (c in ws[idx]){
            s+=score[c-'a']
            charCnts[c-'a']--
            if(charCnts[c-'a']<0){
                canSelect=false
            }
        }
        if (canSelect){ // 能选
            dfs(idx+1,curScore+s) 
        }
        for (c in ws[idx]) charCnts[c-'a']++
    }
}