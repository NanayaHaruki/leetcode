class MagicDictionary() {
    private lateinit var d:Array<String>
    fun buildDict(dictionary: Array<String>) {
        d=dictionary
    }

    fun search(searchWord: String): Boolean {
        for(word in d){
            if(word.length==searchWord.length && word!=searchWord) {

                var diffCnt = 0
                for(i in word.indices){
                    if(word[i]!=searchWord[i]){
                        diffCnt++
                    }
                    if(diffCnt>1) break // 这个单词不行，找下一个
                }
                if(diffCnt<2) return true
            }
        }
        return false
    }

}