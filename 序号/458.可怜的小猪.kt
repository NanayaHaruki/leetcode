import kotlin.math.*
class Solution {
    fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
        // 香农信息熵 H(x)=-∑ P(x)log2[P(x)]
        // buckets桶携带的总信息量为 log2（buckets)比特
        // 每只猪可以试n=test/die 次，还可以留一组，如果喝过n次都没死，可以表达n+1中可能性，信息量为log2(n+1)
        // 要满足要求，需要pigs只猪的信息量大于毒桶的信息量
        // pigs*log2(n+1)>=log2(buckets)
        return ceil(log(buckets.toDouble(),minutesToTest/minutesToDie+1.0)).toInt()
    }
}