class Solution {
public:
    /** 生成杨辉三角前numRows行 */
    vector<vector<int>> generate(int numRows) {
      vector<vector<int>> ans;
      ans.emplace_back(vector<int>{1});
      for(int i = 2;i<=numRows;i++){
        vector<int> curLayer(i,1);
        for(int j=1;j<i-1;j++){
          // 每一位是由上一层的同样索引和前一个索引相加
          curLayer[j]=ans[i-2][j]+ans[i-2][j-1];
        }
        ans.emplace_back(curLayer);
      }
      return ans;
    }
};