class Solution {
private:
  int m,n;
  int check(vector<vector<int>> & board,int row,int col){
    int lifeCnt=0;
    for(int i = row-1;i<=row+1;i++){
      for(int j=col-1;j<=col+1;j++){
        if(i<0||j<0||i>=m||j>=n) continue;
        if(i==row && j==col) continue;
        if(board[i][j]==1) lifeCnt++;
      }
    }
    if(board[row][col]==0){
      if(lifeCnt==3) return 1;
      else return 0;
    }else{
      if(lifeCnt<2) return 0;
      if(lifeCnt>3) return 0;
      return 1;
    }
  }
public:
    /** cell game */
    void gameOfLife(vector<vector<int>>& board) {
      // 0 dead; 1 live
      // 1.活细胞周围少于2个活的，活细胞死；
      // 2.活细胞周围有2或3个活，活细胞活；
      // 3.活细胞周围超过3个活，活细胞死
      // 4.死细胞周围正好3个活，复活；
      m = board.size();n=board[0].size();
      vector<vector<int>> v(m,vector<int>(n));
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
          v[i][j]=check(board,i,j);
        }
      }
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
          board[i][j]=v[i][j];
        }
      }
    }
};