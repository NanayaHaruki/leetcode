class Solution {
 public:
  vector<int> sortedSquares(vector<int>& nums) {
    // 0左边的平方后递减，0后边递增，找到交界线归并排序
    int n = nums.size();
    auto itr = lower_bound(nums.begin(), nums.end(), 0);
    auto itl = itr - 1;
    vector<int> v;
    while (itl >= nums.begin() && itr < nums.end()) {
      // 比对添加小的
      int l = *itl, r = *itr;
      if (r < -l) {
        v.emplace_back(r * r);
        itr++;
      }else{
        v.emplace_back(l*l);
        itl--;
      }
    }
    if(itl<nums.begin()){
      while(itr!=nums.end()){
        int i = *itr;
        v.emplace_back(i*i);
        itr++;
      }
    }else if(itr==nums.end()){
      while(itl>=nums.begin()){
        int i = *itl;
        v.emplace_back(i*i);
        itl--;
      }
    }
    return v;
  }
};