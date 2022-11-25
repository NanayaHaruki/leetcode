class Solution {
public:
    void backTrace(int idx,int n,int k,vector<int> &v,vector<vector<int>> & ans){
      if(v.size()==k){
        ans.emplace_back(v);
        return;
      }
      for(int i=idx;i<=n-k+v.size()+1;i++){
        v.emplace_back(i);
        backTrace(i+1,n,k,v,ans);
        v.pop_back();
      }
    }


    /** [1,n] 返回所有k个数的组合 n<=20 */
    vector<vector<int>> combine(int n, int k) {
      vector<vector<int>> ans;
      vector<int> tmp;
      backTrace(1,n,k,tmp,ans);
      return ans;
    }
};