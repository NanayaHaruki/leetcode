class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& mat, int r, int c) {
        int m = mat.size(),n=mat[0].size();
        if(m*n!=r*c) return mat;
        vector<vector<int>> v(r,vector<int>(c));
        int idx=0;
        for(auto & rows:mat){
          for(int i : rows){
            int curRow = idx/c,curCol=idx%c;
            v[curRow][curCol]=i;
            idx++;
          }
        }
        return v;
    }
};