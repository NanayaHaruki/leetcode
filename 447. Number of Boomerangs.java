/**
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 *
 * 示例:
 *
 * 输入:
 * [[0,0],[1,0],[2,0]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]。
 * @author:xzj
 * @date: 2018/8/1 11:31
 */
class Solution {
    public int numberOfBoomerangs(int[][] points) {
//        存储两点距离出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if (i != j) {
                    int d = gougu(points[i][0] - points[j][0], points[i][1] - points[j][1]);
//                    这个距离出现过，+1，没出现存1
                    map.put(d, map.getOrDefault(d, 0) + 1);
                }
            }
            for(Integer count : map.values()) {
//                某个距离出现过count次，取出一种可能性，回旋镖 A B放好，再取出一种可能性C 1(count-1) ,回旋镖放好 A B C
                result += count * (count - 1);
            }
            map.clear();
        }
        return result;
    }

    int gougu(int x, int y) {
        return x*x+y*y;
    }
}
