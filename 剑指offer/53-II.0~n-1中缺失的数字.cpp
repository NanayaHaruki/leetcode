class Solution {
public:
    int missingNumber(vector<int>& nums) {
      // 长度为n，递增，数本应是【0，n-1】，当前数组为【0，n】，少了个数，找出这个数
      int l = 0,r=nums.size()-1,m;
      while(l<=r){
        m=l+(r-l)/2;

        if(nums[m]==m){ // nums[m] 不可能 < m。要么m前没跳，那么相等；要么m前跳了，nums[m]>m
          l=m+1;
        }else {
          r=m-1;
        }
      }
      return l;
    }
};