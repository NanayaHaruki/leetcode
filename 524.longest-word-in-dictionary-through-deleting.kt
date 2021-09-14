class Solution() {

    fun findLongestWord(s: String, dictionary: List<String>): String {
        // 从s删到 dict里的单词，找最长的那个
        // 根据dict中的单词，从第一个字符在s中找，按顺序，能找到就保存为答案待选，找不到就下一个；
        Collections.sort(dictionary){s1,s2-> if (s1.length==s2.length) s1.compareTo(s2) else s2.length-s1.length}

        for (word in dictionary) {
            var i = 0
            var j = 0
            while (i < s.length && j < word.length) {
                if (s[i] == word[j]) {
                    i++
                    j++
                }else {
                    i++
                }
                if (j==word.length) return word
            }
        }
        return ""
    }
}