class Solution {
 public:
  vector<vector<int>> ans;
  vector<int> tmp;
  vector<int>* used;
  vector<int>* nums;
  int n;
  void backTrace() {
    if (tmp.size() == n) {
      ans.emplace_back(tmp);
      return;
    }
    for (int i = 0; i < n; i++) {
      if(used->at(i)==1) continue;
      tmp.emplace_back(nums->at(i));
      used->at(i)=1;
      backTrace();
      tmp.pop_back();
      used->at(i)=0;
    }
  }
  vector<vector<int>> permute(vector<int>& _nums) {
    used = new vector<int>(_nums.size(), 0);
    nums = &_nums;
    n=nums->size();
    backTrace();
    delete used;
    return ans;
  }
};