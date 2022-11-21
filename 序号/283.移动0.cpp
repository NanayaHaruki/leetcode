class Solution {
 public:
  void moveZeroes(vector<int>& nums) {
    // 统计0的个数，将每个数挪到前面去
    int n = nums.size(),cnt=0;
    for(int i=0;i<n;++i){
      if(nums[i]==0) cnt++;
      else nums[i-cnt]=nums[i];
    }
    for(int i=n-1;cnt>0;cnt--,i--){
      nums[i]=0;
    }
  }
};