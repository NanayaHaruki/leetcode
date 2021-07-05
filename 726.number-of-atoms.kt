class Solution {
    /**
     * 遇（ 压一个Map<String,Int>进栈  遇） 弹栈 ，往后遍历将弹栈出的原子数量 *  ）后面的数字
     * */
    fun countOfAtoms(formula: String): String {
        val stack = Stack<MutableMap<String,Int>>()
        stack.push(mutableMapOf())
        val arr = formula.toCharArray()
        var i = 0
        var yz = ""
        while (i < arr.size) {
            val char = arr[i]
            when {
                char.isUpperCase()->{
                    if (yz.isNotEmpty()) {
                        val map = stack.peek()
                        map[yz]=map.getOrDefault(yz,0)+1
                    }
                    yz=char.toString()
                    i++
                }
                char.isLowerCase()->{
                    yz+=char
                    i++
                }
                char.isDigit()->{
                    val pair = getCnt(arr,i)
                    val map = stack.peek()
                    map[yz]=map.getOrDefault(yz,0)+pair.first
                    yz = ""
                    i = pair.second
                }
                char == '('->{
                    if (yz.isNotEmpty()) {
                        val map = stack.peek()
                        map[yz]=map.getOrDefault(yz,0)+1
                        yz=""
                    }
                    stack.push(mutableMapOf())
                    i++
                }
                char == ')'->{
                    val topMap = stack.pop()
                    if (yz.isNotEmpty()) {
                        topMap[yz]=topMap.getOrDefault(yz,0)+1
                        yz=""
                    }

                    val map = stack.peek()
                    val pair = getCnt(arr,i+1)
                    val cnt = pair.first
                    for ((k,v) in topMap){
                        map[k] = map.getOrDefault(k,0)+  v * cnt //括号里统计的 乘以 括号外的数字
                    }
                    i = pair.second
                }
            }
        }
        val first = stack.pop()
        if (yz.isNotEmpty()){
            first[yz] = first.getOrDefault(yz,0)+1
        }
        val sb = StringBuilder()
        first.toSortedMap().forEach { s, i ->
            sb.append(s)
            if (i>1) sb.append(i)
        }
        return sb.toString()
    }



    /** 返回从startIndex开始的数字  first 为数字 second为不是数字的索引 */
    private fun getCnt(str: CharArray, startIndex: Int): Pair<Int, Int> {
        if (startIndex>=str.size || !str[startIndex].isDigit()) return Pair(1,startIndex)
        var index = startIndex
        var digit = 0
        while (index < str.size && str[index].isDigit()) {
            digit = digit * 10 + (str[index] - '0')
            index++
        }
        return Pair(digit, index)
    }


}