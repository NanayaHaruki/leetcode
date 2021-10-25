import java.util.HashMap;
import java.util.Map;
/**
 * 除数博弈
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。

最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：

选出任一 x，满足 0 < x < N 且 N % x == 0 。
用 N - x 替换黑板上的数字 N 。
如果玩家无法执行这些操作，就会输掉游戏。

只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。



示例 1：

输入：2
输出：true
解释：爱丽丝选择 1，鲍勃无法进行操作。
示例 2：

输入：3
输出：false
解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。


提示：

1 <= N <= 1000
 * */
class Solution {
    // N为1，Alice作为先手，不存在0<x<1的数，直接就输了。
    // N为2，Alice选1，Bob选不出0<x<2-1的数，Alice赢
    // N为3，Alice选1，Bob只能在0<x<3-1=2 ,只能选1，Alice输。
    // N为4，Alice选1，Bob在1,2中选；1、Bob选1，Alice在N=3中选，结果如上一行，Alice输；Bob选2，相当于第2行的情况，Alice也会输。
    // 所以奇数Alice会输，偶数会赢
    fun divisorGame(N: Int): Boolean {
        return N % 2 == 0

    }
}

