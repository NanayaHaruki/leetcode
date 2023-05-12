import kotlin.math.abs

class Solution {
    fun maxValueAfterReverse(nums: IntArray): Int {

        // 交换子数组后，每相邻的数差的绝对值最大。子数组内部和不会变化，因为|x-y|=|y-x。外部也不会变，只有交界处会发生变化。
        // a<b<c<d  变化后的差值 = |c-a|+|d-b| - |b-a| - |d-c|。 要求这个最大，先去绝对值
        // diff= max(c-a,a-c) + max(d-b,b-d) - |b-a| - |d-c|
        //     = max(c-a+d-b,c-a+b-d,a-c+d-b,a-c+b-d) -|b-a|-|d-c|   将ab与cd分开，遍历时ab一组 cd一组
        //     = max(-a-b+c+d,-a+b+c-d,a-b-c+d,a+b-c-d) 遍历时维护四种状态的最大值，即可求出 diff
        val n = nums.size
        val start = nums[0];
        val end = nums[n - 1]
        var sum = 0
        var mxDiff = 0
        val status = IntArray(4) { -0x3f3f3f3f } // a+b a-b -a+b -a-b
        for (i in 0 until n - 1) {
            val a = nums[i];
            val b = nums[i + 1]
            val diff: Int = abs(b - a)
            sum += diff
            mxDiff = maxOf(
                mxDiff,
                intArrayOf(
                    abs(start - b), abs(end - a),
                    status[3] + a + b,
                    status[2] + a - b,
                    status[1] - a + b,
                    status[0] - a - b
                ).max()!! - diff
            )
            status[0] = maxOf(status[0], a + b - diff)
            status[1] = maxOf(status[1], a - b - diff)
            status[2] = maxOf(status[2], -a + b - diff)
            status[3] = maxOf(status[3], -a - b - diff)
        }
        return sum + mxDiff
    }
}