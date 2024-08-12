class Node {
    var isFinished = false
    val children = Array<Node?>(26) { null }
}

class MagicDictionary() {
    val root = Node()
    fun buildDict(dictionary: Array<String>) {
        var p = root
        for (word in dictionary) {
            p = root
            for (c in word) {
                if (p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = Node()
                }
                p = p.children[c - 'a']!!
            }
            p.isFinished = true
        }
    }

    private fun dfs(node: Node, word: String, i: Int, isChanged: Boolean): Boolean {
        val c = word[i]
        if (i == word.length - 1) {
            if (node.children[c - 'a']?.isFinished == true && isChanged)
                return true
            for (j in 0 .. 25) {
                if (!isChanged && j != c - 'a' && node.children[j] != null && node.children[j]!!.isFinished)
                    return true
            }
            return false
        }
        if (node.children[c - 'a'] != null && dfs(node.children[c - 'a']!!, word, i + 1, isChanged)) {
            return true
        }
        if (isChanged) return false
        for (j in 0 .. 25) {
            val child = node.children[j]
            if (child == null || j==c-'a') continue
            if (dfs(child, word, i + 1, true))
                return true // 换这个字符ok，直接返回;否则继续换别的字符
        }
        return false

    }

    fun search(searchWord: String): Boolean {
        return dfs(root, searchWord, 0, false)
    }
}

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