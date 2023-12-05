class Solution {
vector<int> v;
void dfs(int idx,vector<int>& c,int target,vector<vector<int>> & ans){
  if(idx>=c.size()) return;
  int x;
  for(int i=idx;i<c.size();++i){
    x=c[i];
    if (x>target) break;
    v.emplace_back(x);
    if(x==target) ans.emplace_back(v);
    dfs(i,c,target-x,ans);
    v.pop_back();
  }
}
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        sort(candidates.begin(),candidates.end());
        dfs(0,candidates,target,ans);
        return ans;
    }
};