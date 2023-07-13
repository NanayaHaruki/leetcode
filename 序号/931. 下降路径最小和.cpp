class Solution {
 public:
  int minFallingPathSum(vector<vector<int>>& matrix) {
    int m=matrix.size(),n=matrix[0].size();
    if(m==1) return *min_element(matrix[m-1].begin(),matrix[m-1].end());
    int ans=INT_MAX;
    for(int i=m-2;i>=0;i--){ // 从下往上遍历，每个位置保存向下的最小和
        for(int j=0;j<n;j++){
            if(j==0){
                if(n>1) matrix[i][j]+=min(matrix[i+1][0],matrix[i+1][1]);
                else matrix[i][j]+=matrix[i+1][0];
            }else if(j==n-1){
                if(n>1) matrix[i][j]+=min(matrix[i+1][j-1],matrix[i+1][j]);
                else matrix[i][j]+=matrix[i+1][j];
            }else{
                matrix[i][j]+=min(matrix[i+1][j-1],min(matrix[i+1][j],matrix[i+1][j+1]));
            }
            if(i==0){
                ans=min(ans,matrix[i][j]);
            }
        }
    }
    return ans;
  }
};