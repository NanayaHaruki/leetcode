class Solution {
public:
  /** 返回nums乘积，正数1 负数-1 0 */
    int arraySign(vector<int>& nums) {
      // 数符号就是了
      int ans=0;
      for(auto &i :nums){
        if(i==0) return 0;
        else if(i<0) ans++;
      }
      return ans%2==0?1:-1;
    }
};