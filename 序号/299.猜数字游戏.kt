class Solution {
    fun getHint(secret: String, guess: String): String {
        // 分别统计2个字符串里每个数字出现的次数，当较小的就是命中数字的次数（这里位置不一定对）
        // 位置对的，在遍历的时候对比字符统计出来
        // 统计数量的时候要将位置数量都对的剔除掉
        val oriArr = IntArray(10) // 存储secret的数字
        val guessArr = IntArray(10) // 存储guess的数字
        val correctArr = IntArray(10) // 位置正确的个数
        val n = secret.length
        for (i in 0 until n){
            val s = secret[i]-'0'
            val g = guess[i]-'0'
            if (s==g){
                // 位置相同，数字也相同的记下来
                correctArr[s]++
            }
            // 将数字放进对应索引
            oriArr[s]++
            guessArr[g]++
        }
        var indexRightCnt = 0
        var numberRightCnt = 0
        for (i in 0 ..9){
            // 较小的是猜中数字的个数，比如原来有2个3  猜有5个3,猜中2个； 原来有2个3,猜1个3,猜中1个；
            numberRightCnt+= minOf(oriArr[i],guessArr[i])
            // 有位置正确的，单独记录在indexRightCnt中，从数字正确中扣除掉
            if (correctArr[i]>0) {
                indexRightCnt+=correctArr[i]
                numberRightCnt-=correctArr[i]
            }
        }
        return "${indexRightCnt}A${numberRightCnt}B"
    }
}