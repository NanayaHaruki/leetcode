class Solution {
  private:
  void dfs(vector<vector<char>> & v,int row,int col){
    if(row>=0 && row <v.size() && col>=0 && col<v[0].size() && v[row][col]=='O'){
      v[row][col]='1';
      dfs(v,row+1,col);
      dfs(v,row-1,col);
      dfs(v,row,col-1);
      dfs(v,row,col+1);
    }
  }
  public:
  /** 将被X包围的改成X */
  void solve(vector<vector<char>>& board) {
    // 将与边界的O连接的O 改成A； 将其他O替换成x ； 将边界的改回来O
    // m n 属于 1-200
    int m = board.size(),n=board[0].size();
    for(int i=0;i<n;i++){
      dfs(board,0,i);
      dfs(board,m-1,i);
    }
    for(int i = 0;i<m;i++){
      dfs(board,i,0);
      dfs(board,i,n-1);
    }
    // 替换
    char c;
    for(int i = 0;i<m;i++){
      for(int j = 0;j<n;j++){
        c=board[i][j];
        if(c=='O') board[i][j]='X';
        else if(c=='1') board[i][j]='O';

      }
    }
  }
};