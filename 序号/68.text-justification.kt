class Solution() {

    /** 空格平均分配，每行maxwidth 不能平均，空格左边大于右边；最后一行靠左 */
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        // 遍历words，空格至少这行单词-1,贪心往每一行塞
        val ans = mutableListOf<String>()
        val lineWords = ArrayDeque<String>()
        var lineLength = 0
        for (i in words.indices) {
            val word = words[i]
            when {
                lineLength == 0 -> {
                    lineLength = word.length
                    lineWords.add(word)
                }
                lineLength + word.length < maxWidth -> {
                    // 除了第一个单词，后面的除了加自己的长度，还得加一个空格，否则进else另起一行
                    lineLength += word.length + 1
                    lineWords.addLast(word)
                }
                else -> {
                    if (lineWords.size==1){
                        val sb = StringBuilder(lineWords.removeFirst())
                        repeat(maxWidth-sb.toString().length){
                            sb.append(' ')
                        }
                        ans.add(sb.toString())
                    }else {
                        // 加不了，计算好空格，存进ans
                        // 先计算需要多少个空格，根据单词数量计算每处多少空格，模为前几个空要再增加的空格
                        val spaceCnt = lineWords.size - 1
                        // 目前的长度-空格个数 为单词总长，根据总长，计算每个空格长度
                        val wordLengthSum = lineLength - spaceCnt
                        val spaceLengthUnit = (maxWidth - wordLengthSum) / spaceCnt
                        val modSpaceSum = (maxWidth - wordLengthSum) % spaceCnt
                        val spaceArr = IntArray(spaceCnt) { spaceLengthUnit }
                        for (j in 0 until modSpaceSum) {
                            spaceArr[j] += 1
                        }
                        val sb = StringBuilder(lineWords.removeFirst())
                        for (spaceLength in spaceArr) {
                            repeat(spaceLength) {
                                sb.append(" ")
                            }
                            sb.append(lineWords.removeFirst())
                        }
                        ans.add(sb.toString())
                        // 当前单词超了，上面为保存上一行，现在要为当前遍历到的单词另起一行
                    }
                    lineWords.add(word)
                    lineLength = word.length
                }
            }
        }
        // 遍历完最后，可能队列中还有东西，最后一行靠左排列
        if (lineWords.isNotEmpty()) {
            val sb = StringBuilder(lineWords.removeFirst())
            while (lineWords.isNotEmpty()) {
                sb.append(" ").append(lineWords.removeFirst())
            }
            repeat(maxWidth-sb.length){
                sb.append(' ')
            }
            ans.add(sb.toString())
        }
        return ans
    }
}