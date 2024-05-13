994. 腐烂的橘子
    LeetCode Logo

每日一题
712
Plus 会员
题目描述
通过
通过
题解
题解
提交记录
提交记录
代码
代码
代码示例
测试用例
测试用例
测试结果
994. 腐烂的橘子
已解答
算术评级: 4
第 124 场周赛
Q2
1433
相关标签
相关企业

在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：

    值 0 代表空单元格；
    值 1 代表新鲜橘子；
    值 2 代表腐烂的橘子。

每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。

返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。

 

示例 1：

输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
输出：4

示例 2：

输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
输出：-1
解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。

示例 3：

输入：grid = [[0,2]]
输出：0
解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。

 

提示：

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 10
    grid[i][j] 仅为 0、1 或 2

面试中遇到过这道题?
1/5
是
否
通过次数
169.7K
提交次数
329.3K
通过率
51.5%
相关标签
广度优先搜索
数组
矩阵
相关企业
相似题目
墙与门
中等
评论 (1.1K)
💡 讨论区规则

1. 请不要在评论区发表题解！

2. 评论区可以发表关于对翻译的建议、对题目的疑问及其延伸讨论。

3. 如果你需要整理题解思路，获得反馈从而进阶提升，可以去题解区进行。
Mr.White
发布于 福建
10 小时前

腐烂的不是橘子, 是我刷题的❤️
8
回复
wxyz
发布于 中国
10 小时前

烂橘子，时隔一年，又又又见面了
6
回复
xPatrL
发布于 江苏(编辑过)
10 小时前

《橘子短暂而壮烈的一生》
模拟即可

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] infectTime = new int[m][n]; // -1: not infected yet; -2: empty
        int t = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) infectTime[i][j] = -2;
                if (grid[i][j] == 1) infectTime[i][j] = -1;
                if (grid[i][j] == 2) infectTime[i][j] = 0;
            }
        }
        while (true) {
            boolean infected = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (infectTime[i][j] == t) {
                        if (i - 1 >= 0 && infectTime[i - 1][j] == -1) {
                            infectTime[i - 1][j] = t + 1;
                            infected = true;
                        }
                        if (i + 1 < m && infectTime[i + 1][j] == -1) {
                            infectTime[i + 1][j] = t + 1;
                            infected = true;
                        }
                        if (j - 1 >= 0 && infectTime[i][j - 1] == -1) {
                            infectTime[i][j - 1] = t + 1;
                            infected = true;
                        }
                        if (j + 1 < n && infectTime[i][j + 1] == -1) {
                            infectTime[i][j + 1] = t + 1;
                            infected = true;
                        }
                    }
                }
            }
            if (!infected) break;
            t++;
        }
        for (int[] row : infectTime) {
            for (int x : row) {
                if (x == -1) return -1;
            }
        }
        return t;
    }
}

展开全部
2
回复
Lopez-Lu
发布于 美国(编辑过)
8 小时前

比Orange更烂的还在后头呢 ..

// <-.#.time:2024.5.12 周日 2 .. 
/**
    【 <- 994.腐烂的橘子: 】
 */
class Solution {
        int N; 
        int M; 

        private static class Point {
                int x; 
                int y; 
                Point(int x, int y) { this.x = x; this.y = y; }
        }
        private boolean isValidPoint(Point p) {
                return (p.x >= 0 && p.x < this.N) && (p.y >= 0 && p.y < this.M); 
        }
        public int orangesRotting(int[][] grid) {
                int n = grid.length; int m = grid[0].length; 
                this.N = n; 
                this.M = m; 

                int cnt = 0;    // <-.非零单元格数: ↓ 
                List<Point> Infections = new ArrayList<>(); 

                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                                if (grid[i][j] != 0) {
                                        cnt += 1 ; 
                                        if (grid[i][j] == 2) {
                                                Infections.add(new Point(i, j)); 
                                        }
                                }
                        }
                }
                if (cnt == 0) 
                        return 0;   // <-.全零单元格: ↑. 
                int totalInfected = Infections.size(); 
                if (totalInfected == 0) {
                        return -1;  // <-.全是新鲜橘子: ↑. 
                }

                int ans = 0; 
                while (totalInfected < cnt) {
                        final List<Point> __nextInfections = new ArrayList<>(); 

                        for (Point r : Infections) {
                                // <-.上:
                                Point up = new Point(r.x - 1, r.y);
                                if (isValidPoint(up) && grid[up.x][up.y] == 1) {
                                        __nextInfections.add(up); 
                                        grid[up.x][up.y] = 2; 
                                }
                                // <-.右: 
                                Point right = new Point(r.x, r.y + 1); 
                                if (isValidPoint(right) && grid[right.x][right.y] == 1) {
                                        __nextInfections.add(right); 
                                        grid[right.x][right.y] = 2; 
                                } 
                                // <-.下: 
                                Point bottom = new Point(r.x + 1, r.y); 
                                if (isValidPoint(bottom) && grid[bottom.x][bottom.y] == 1) {
                                        __nextInfections.add(bottom); 
                                        grid[bottom.x][bottom.y] = 2; 
                                }
                                // <-.左:
                                Point left = new Point(r.x, r.y - 1); 
                                if (isValidPoint(left) && grid[left.x][left.y] == 1) {
                                        __nextInfections.add(left); 
                                        grid[left.x][left.y] = 2; 
                                }
                        }
                        if (__nextInfections.size() == 0 && totalInfected < cnt) {
                                return -1;  // <-.存在新鲜1橘子被0隔离开的情况: ↑↑↑: 
                        }
                        Infections = __nextInfections; totalInfected += __nextInfections.size(); 
                        ans += 1; 
                }
                return ans; 
        }
}
/* <-.tips:【 模拟一下rottedProcedure: 】学透bfs之后应该能够Linked到BFS的概念的(Not that confused): ↑. */

展开全部
1
回复
KZHU
发布于 上海
10 小时前

4级 不必理会
1
回复
面向测试编程专家
发布于 广东
7 小时前

C语言，一遍过

int orangesRotting(int** grid, int gridSize, int* gridColSize) {

int m=gridSize,n=gridColSize[0];
int count=0 , a=-1;
int time=0;//次数
for(int i=0;i<m;i++)
    for(int j=0;j<n;j++)
        if(grid[i][j]==1) count++;//记新鲜橘子的总数

while(count>0)
{
    if(a==count) return -1;//新鲜橘子数大于0，但上一轮未新增烂橘子，无法让所有橘子腐烂
    a=count;//记录本轮起始时新鲜橘子个数，用于与下轮比较
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(grid[i][j]==2)//如果遍历遇到烂橘子，准备感染周围
            {
                if(i-1>=0) //向上                   
                    if(grid[i-1][j]==1)
                    {
                        grid[i-1][j]=3;//置为3来表示这是准备腐烂的橘子，与本轮已经腐烂的区分开
                        count--;
                    }
                
                if(i+1<m) //向下
                    if(grid[i+1][j]==1)
                    {
                        grid[i+1][j]=3;
                        count--;
                    }
                
                if(j-1>=0) //向左
                    if(grid[i][j-1]==1)
                    {
                        grid[i][j-1]=3;
                        count--;
                    }
                
                if(j+1<n) //向右                   
                    if(grid[i][j+1]==1)
                    {
                        grid[i][j+1]=3;
                        count--;
                    } 
            }
        }
    }
    for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
            if(grid[i][j]==3) grid[i][j]=2;//让标记为3的橘子正式腐烂
    time++;
}
return time;

}
展开全部
1
展示 1 条回复
回复
chenjiejay100
发布于 上海
2024.04.14

取TM的橘子
3
回复
心爱想抱抱智乃
1024 限定勋章
发布于 安徽
42 分钟前

用 bfs 模拟每秒钟的网格状态，直到再无可污染的新鲜橘子为止。记得一开始记录一下新鲜橘子的数量，如果污染停止后仍有剩余就返回 -1，否则返回经过的时间。

class Solution {
    private static final int[][] HOUKOU = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        int shinsen = 0, taimu = 0;
        Queue<int[]> q = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    ++shinsen;
                } // if (grid[i][j] == 1)
                else if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } // else if (grid[i][j] == 2)
            } // for (int j = 0; j < n; ++j)
        } // for (int i = 0; i < m; ++i)

        while (shinsen > 0 && !q.isEmpty()) {
            ++taimu;
            for (int k = q.size(); k != 0; --k) {
                int i = q.peek()[0], j = q.poll()[1];
                for (int[] hk : HOUKOU) {
                    int y = i + hk[0], x = j + hk[1];
                    if (0 <= y && y < m &&
                        0 <= x && x < n &&
                        grid[y][x] == 1) {
                        --shinsen;
                        grid[y][x] = 2;
                        q.offer(new int[]{y, x});
                    } // if (0 <= y && y < m && ...)
                } // for (int[] hk : HOUKOU)
            } // for (int k = q.size(); k != 0; --k)
        } // while (shinsen > 0 && !q.isEmpty())

        return shinsen > 0 ? -1 : taimu;
    } // orangesRotting(int[][])
} // Solution Class

展开全部
0
回复
小可爱香菜
发布于 广东
1 小时前

好好好，前几天浇水长大的橘子吃不完 今天腐烂了是吧
0
回复
Jizhou
发布于 上海
1 小时前

这个题目是不是之前出过
0
回复
贡献者
© 2024 领扣网络（上海）有限公司
通过
执行用时: 37 ms
Case 1
Case 2
Case 3
Case 4
输入
grid =
[[2,1,1],[1,1,0],[0,1,1]]
输出
4
预期结果
4
贡献测试用例
执行用时：20ms
python

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        row, col, time = len(grid), len(grid[0]), 0
        cnt = 0
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        queue = []
        # add the rotten orange to the queue
        for i in range(row):
            for j in range(col):
                if grid[i][j] == 2:
                    queue.append((i, j, time))
                elif grid[i][j] == 1:
                    cnt += 1
        # bfs
        while queue:
            i, j, time = queue.pop(0)
            for di, dj in directions:
                if 0 <= i + di < row and 0 <= j + dj < col and grid[i + di][j + dj] == 1:
                    cnt -= 1
                    grid[i + di][j + dj] = 2
                    queue.append((i + di, j + dj, time + 1))
        # if there are still fresh oranges, return -1
        if cnt: return -1

        return time


        

