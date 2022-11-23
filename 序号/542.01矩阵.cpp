class Solution {
 public:
  int dirs[4][2]{{-1,0},{1,0},{0,1},{0,-1}};
  /**返回每个位置到达附近最近0的距离*/
  vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
    int rows = mat.size(), cols = mat[0].size(),x,y,nx,ny;
    // bfs找最近，dfs找最远；
    // 多源bfs不能原地修改，因为别人还要用，需要先讲源头加进队列; 
    // 因为原地修改，mat存储的是到0的距离，1会有二义性（原本就是1，未被访问过；被访问过，到0的距离是1）
    // 先将1更改为-1，整数就是访问过的且到0 的距离(更常见的方式是用个visited存储起来)
    queue<pair<int, int>> q;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (mat[i][j] == 0) {
          q.emplace(i, j);
        }else{
          mat[i][j]=-1;
        }
      }
    }

    while (!q.empty()) {
      x=q.front().first;y=q.front().second;
      q.pop();
      for(auto &dir:dirs){
        nx=x+dir[0];ny=y+dir[1];
        if(nx>=0&& nx<rows && ny>=0&&ny<cols && mat[nx][ny]==-1){
          mat[nx][ny]=mat[x][y]+1;
          q.emplace(nx,ny);
        }
      }
    }
    return mat;
  }
};