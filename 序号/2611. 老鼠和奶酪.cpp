class Solution {
 public:
  int miceAndCheese(vector<int>& reward1, vector<int>& reward2, int k) {
    // 吃k块奶酪最大得分
    vector<vector<int>> v;
    int n=reward1.size();
    for(int i=0;i<n;i++){
      int a=reward1[i],b=reward2[i];
      vector<int> cur{a-b,a,b};
      v.emplace_back(cur);     
    }
    int ans=0;
    sort(v.begin(),v.end(),[](vector<int> const &a,vector<int> const &b){return b[0]<a[0];});
    for(int i=0;i<n;i++){
      if(i<k){
        ans+=v[i][1];
      }else{
        ans+=v[i][2];
      }
    }
    return ans;
}