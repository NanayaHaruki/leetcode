int m ,n,k;

void shiftXY(int xy[]){
  int x = xy[1]+k;
  xy[1] = x%n;
  xy[0]= (xy[0]+x/n)%m;

}
vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int _k) {
  // grid中每个数往右挪k
  m=grid.size();n=grid[0].size();k=_k;
  list<int> l;// 缓存大小取决于第一个点与移动k次后的点的距离，这个距离未必是k，因为k可能转几圈回来。
  int xy[] {0,0};
  shiftXY(xy);
  int targetX=xy[0],targetY=xy[1];
  bool tempFull = false;
  for (int i = 0; i < m; ++i) {
    for (int j = 0; j < n; ++j) {
        xy[0]=i;xy[1]=j;
        shiftXY(xy);
        if(!tempFull && i==targetX && j == targetY) tempFull=true;
        if(!tempFull) {
          l.push_back( grid[xy[0]][xy[1]]);
          grid[xy[0]][xy[1]]=grid[i][j];
        }else{
          l.push_back(grid[xy[0]][xy[1]]);
          grid[xy[0]][xy[1]] = l.front();
          l.pop_front();
        }
        // cout<<xy[0]<<' '<<xy[1]<<'='<<grid[xy[0]][xy[1]]<<endl;
    }
  }
  return grid;
}