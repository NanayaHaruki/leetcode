import kotlin.math.min
import kotlin.booleanArrayOf


fun main() {
    val i = Solution().longestRepeating(a,b,c)
    print(a)
    3  2
}

class Solution {
    fun minimumSwap(s1: String, s2: String): Int {
        // xx                       xy                yy
        // yy 斜着交换即可都变成yx    yx 先垂直替换 变成 xx 再对角线替换
        // 计算x和y的个数，如果都是偶数，需要替换 n/2,如果都是奇数需要多一次操作
        var cntx = 0
        var cnty = 0
        for(i in s1.indices){
            if(s1[i]!=s2[i]){
                if(s1[i]=='x') cntx++
                else cnty++
            }
        }
        val d = cntx+cnty
        return if(d & 1 == 1) -1 else {
            if(cntx&1==1){
                d /2 + 1
            }else{
                d/2
            }
        }
    }
}